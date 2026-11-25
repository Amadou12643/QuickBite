import java.util.*;

public class FoodTruck {

    // Data structure to hold our MenuItem
    private Map<String, MenuItem> menu = new HashMap<>();
    //private Queue<Order> line = new ArrayDeque<>(); //queue
    private Deque<Order> recent = new ArrayDeque<>(); //stack
    private Queue<Order> line = new PriorityQueue<>(
            Comparator.comparingInt((Order o) -> o.getCustomer().getPriority()).reversed()
                    .thenComparingInt(Order::getNumber)
    );

    // Method to add an item
    public void addItem(MenuItem item) {
        menu.put(item.getCode(), item);
    }

    // Method to print the menu
    public void printMenu() {
        for (MenuItem item : menu.values()) {
            System.out.println(item);
        }
    }

    // Find item by code
    public MenuItem findItemByCode(String code) {
        return menu.get(code);
    }

    // Place an order
    public void placeOrder(Customer customer, String code) {
        MenuItem item = findItemByCode(code);
        if (item == null) {
            System.out.println("Item not on the menu");

        } else if (item.canOrder()) {
            line.offer(new Order(customer, item));

            System.out.println("Order placed: " + item.getName());

        } else {
            System.out.println("Sorry, " + item.getName() + " is sold out");
        }
    }

    public Order serveNext() {
        Order served = line.poll();
        if (served != null) { //only served when the line is not empty
            served.getCustomer().addTohistory(served); // place the order in the history
            recent.push(served); // newest goes on top

            if (recent.size() > 3) {
                recent.removeLast(); // drop the oldest
            }

        }
        return served;
    }
    public void printRecent() {
        for (Order o : recent) {
            System.out.println(o);
        }
    }

    public TreeMap<Double, List<MenuItem>> menuByPrice() {
        TreeMap<Double, List<MenuItem>> sorted = new TreeMap<>();

        for (MenuItem item : menu.values()) {
            sorted.computeIfAbsent(item.getPrice(), p -> new ArrayList<>()).add(item);
        }
        return sorted;
    }

    public void printMenuByPrice() {
        for (Map.Entry<Double, List<MenuItem>>ventry : menuByPrice().entrySet()){
            for (MenuItem item : ventry.getValue()) {
                System.out.println(item);
            }
        }

    }
}