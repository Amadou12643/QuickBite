public class Main {
    public static void main(String[] args) {

        // QuickBite
        // Items names, prices, and availabilities
        String[] itemName = {"Benachin", "Fufo", "Juice"};
        double[] itemPrice = {5.5, 10.7, 12.5};
        boolean[] itemAvailable = {true, false, true};

        // Print the items one-by-one
        for (int i = 0; i < itemName.length; i++) {

            // Print item name and price
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
    }
}