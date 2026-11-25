import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * printFinalPrice
     * This method is going to determine the final price each customer is paying
     * @param customer
     * @param price
     */
    public static void  printFinalPrice(Discountable customer, double price){
        System.out.printf("You pay: GMD%.2f%n", customer.applyDiscount(price));

    }
    public void main() {


        // create a FoodTruck obj (object)
        FoodTruck truck = new FoodTruck();
        MenuItem item1 = new MenuItem("i1", "Buscuits", 15.00, true);
        MenuItem item2 = new MenuItem("i2", "Bananas", 100.00, false);
        MenuItem item3 = new MenuItem("i3", "Driay Chocolete", 250.00, true);
        MenuItem item4 = new MenuItem("i4", "Cake", 50.00, true);
        MenuItem item5 = new MenuItem("i5", "Ice Cream", 250.00, false);
        MenuItem item6 = new MenuItem("i6", "Sawarama", 100.00, true);
        MenuItem item7 = new MenuItem("i7", "Fruit Drinks", 50.00, true);

        // load the food  truck
        truck.addItem(item1);
        truck.addItem(item2);
        truck.addItem(item3);
        truck.addItem(item4);
        truck.addItem(item5);
        truck.addItem(item6);
        truck.addItem(item7);

        truck.printMenu();

        // Creating VIP and Regular Customer
        List<Customer>line = new ArrayList<>();
        line.add(new RegularCustomer("Lamin"));
        line.add(new RegularCustomer("Awa"));
        line.add(new vipCustomer("Binta"));
        // Printing the priority of customers
        for (Customer c : line) {
            System.out.println(c.describe());
        }

        // Get the first customer from the line
        if (!line.isEmpty()) {
            Customer next = line.get(0);

            for (Customer c : line) {
                // Check for the customer with the highest priority
                if (c.getPriority() < next.getPriority()) {
                    next = c;
                }
            }

            System.out.println();
            System.out.println("Serving " +next.getName());

            System.out.println("---------------");
            printFinalPrice(new RegularCustomer("Lamin"), 100);
            printFinalPrice(new vipCustomer("Ida"), 100);
        }
        System.out.println("----------------------PLACING ORDER ----------------------");
        //place tree customer
        truck.placeOrder(new RegularCustomer("Amie"), item1.getCode());
        truck.placeOrder(new RegularCustomer("Maimuna"), item2.getCode());
        truck.placeOrder(new RegularCustomer("Isatou"), item3.getCode());
        truck.placeOrder(new RegularCustomer("kumba"), item4.getCode());
        truck.placeOrder(new RegularCustomer("Ebriama"), item5.getCode());
        truck.placeOrder(new vipCustomer("Barry"), item6.getCode());

        System.out.println("------------- SERVER NEXT ----------------");
        System.out.println(truck.serveNext());
        System.out.println(truck.serveNext());
        System.out.println(truck.serveNext());
        System.out.println(truck.serveNext());
        System.out.println(truck.serveNext());

        // recent
        System.out.println("---------------------- RECENT ----------------------");
        truck.printRecent();

    }


    }


}