package abstractExample;

public class TaxedItem extends OrderItem {

    public TaxedItem(String name, double basePrice) {
        super(name, basePrice);
    }


    @Override
    double getFinalPrice() {
        return getBasePrice() + getBasePrice() * 0.14;
    }
}
