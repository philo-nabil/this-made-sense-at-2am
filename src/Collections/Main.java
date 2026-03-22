package Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static void main() {
        List<String> incomingOrder = new ArrayList<>();

        incomingOrder.add("Order#1-Laptop");
        incomingOrder.add("Order#2-Phone");
        incomingOrder.add("Order#3-Laptop");
        incomingOrder.add("Order#4-Tablet");

        //System.out.println(incomingOrder);
        Set<String> uniqueOrders = new HashSet<>();
        for (String s : incomingOrder) {
            String[] parts = s.split("-");
            uniqueOrders.add(parts[1]);
        }
        System.out.println(uniqueOrders);


    }
}
