package abstractExample;

public class DiscountedItem extends OrderItem {

    private final double discount;

    public double getDiscount() {
        return discount;
    }

    public DiscountedItem(String name, double basePrice, double discount) {
        super(name, basePrice);
        this.discount = discount;
    }


    @Override
    double getFinalPrice() {
        return getBasePrice() - getDiscount();
    }
}
