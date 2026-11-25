import java.time.LocalDateTime;

public class Order {
    private static int nextNumber = 1;
    private final Customer Customer;

    private int number;
    private Customer customer;
    private MenuItem item;
    private LocalDateTime placeAt;

    public Order(Customer customer, MenuItem item){
        this.number = nextNumber++; // POST increment
        this.Customer = customer;
        this.item =item;
        this.placeAt = LocalDateTime.now();
    }

    public static int getNextNumber() {
        return nextNumber;
    }

    public int getNumber(){
        return nextNumber;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public MenuItem getItem() {
        return item;
    }

    public LocalDateTime getPlaceAt() {
        return placeAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Customer=" + Customer +
                ", number=" + number +
                ", customer=" + customer +
                ", item=" + item +
                ", placeAt=" + placeAt +
                '}';
    }
}