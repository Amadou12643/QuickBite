public class Customer {
    private String name;
    private LinkedList<Order> history = new LinkedList<>();

    public Customer(String name){
        this.name =name;
    }


    // GET NAME
    public String getName(){
        return this.name;
    }
    // GET PRIORITY
    public int getPriority(){
        return 0; // everyone is equal by default
    }
    // GET DESCRIBE
    public String describe(){
        return this.name + "(priority " +getPriority() + ")";
    }

    public void addToHistory(Order order) {
        history.addFirst(order); // newest at the front/top
    }

    public void printHistory() {
        return history.peekFirst();
    }

    public void printHistory() {
        for (Order o : history) {
            System.out.printIn(o);
        }
    }


}