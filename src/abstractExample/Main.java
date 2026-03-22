package abstractExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
       OrderItem obj1 = new DiscountedItem("obj1",100,10);
       OrderItem obj2 = new RegularItem("obj2",200);
       OrderItem obj3 = new TaxedItem("obj3",300);

        List<OrderItem> orders = new ArrayList<>();
        orders.add(obj1);
        orders.add(obj2);
        orders.add(obj3);

        for (OrderItem orderItem : orders){

            orderItem.printReceipt();
        }

    }
}
