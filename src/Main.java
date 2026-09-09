import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // QuickBite
        // Initialize your scanner object
        Scanner in = new Scanner(System.in);

        // Items names, prices, and availabilities
        String[] itemName = {"Benachin", "Fufo", "Juice"};
        double[] itemPrice = {5.5, 10.7, 12.5};
        boolean[] itemAvailable = {true, false, true};

        // Add items to the arrays using Scanner
        do {
            System.out.println("Are you adding item? Y or N");
            String userinput = in.next();

            if (userinput.equalsIgnoreCase("n")) {
                break;
            }

            System.out.println("Enter item name:");
            String name = in.next();

            System.out.println("Enter item price:");
            double price = in.nextDouble();

            System.out.println("Enter item status (true/false):");
            boolean status = in.nextBoolean();

            System.out.println("Name \t Price \t Status");
            System.out.println(name + "\t" + price + "\t" + status);

            // Add new item to the store

            // Resize itemName array
            itemName = Arrays.copyOf(itemName, itemName.length + 1);
            itemName[itemName.length - 1] = name;

            // Resize itemPrice array
            itemPrice = Arrays.copyOf(itemPrice, itemPrice.length + 1);
            itemPrice[itemPrice.length - 1] = price;

            // Resize itemAvailable array
            itemAvailable = Arrays.copyOf(itemAvailable, itemAvailable.length + 1);
            itemAvailable[itemAvailable.length - 1] = status;

            System.out.println(Arrays.toString(itemName));
            System.out.println(Arrays.toString(itemPrice));
            System.out.println(Arrays.toString(itemAvailable));

        } while (true);

        // Print the items one-by-one
        System.out.println("\n===== QUICKBITE ITEMS =====");

        for (int i = 0; i < itemName.length; i++) {

            System.out.println("Item: " + itemName[i]);
            System.out.println("Price: " + itemPrice[i]);

            // Check availability
            if (itemAvailable[i]) {
                System.out.println("Available");
            } else {
                System.out.println("Sold Out");
            }

            System.out.println("-------------------");
        }

        // Linear search by item name
        System.out.println("\n===== SEARCH ITEM =====");
        System.out.println("Enter the item name to search:");

        String searchTerm = in.next();

        boolean found = false;

        for (int i = 0; i < itemName.length; i++) {

            if (itemName[i].equalsIgnoreCase(searchTerm)) {
                System.out.println("Item: " + itemName[i]);
                System.out.println("Price: " + itemPrice[i]);
                System.out.println("Available: " + itemAvailable[i]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(searchTerm + " not found");
        }

        in.close();
    }
}