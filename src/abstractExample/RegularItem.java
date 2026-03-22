package abstractExample;

public class RegularItem extends OrderItem{
    public RegularItem(String name, double basePrice) {
        super(name, basePrice);
    }


    @Override
    double getFinalPrice() {
        return getBasePrice();
    }
}
