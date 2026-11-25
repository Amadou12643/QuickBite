public class vipCustomer extends Customer implements Discountable{
    public vipCustomer(String name) {
        super(name);
    }

    @Override
    public int getPriority() {
        return  1; // VIP Customer has priority of 1 (they are skipped ahead from the line)
    }

    @Override
    public double applyDiscount(double price) {
        return price *0.90; // 10% of
    }
}