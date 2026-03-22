package abstractExample;

public abstract class OrderItem {

    private final String name;
    private final double basePrice;

    abstract double getFinalPrice();

    void printReceipt(){
        System.out.println("Item: " + name +" , Price: " + getFinalPrice() + "\n");
    }

    public double getBasePrice() {
        return basePrice;
    }



    public OrderItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }
}
