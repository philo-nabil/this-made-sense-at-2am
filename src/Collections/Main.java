package Collections;

import java.util.*;

public class Main {
    static void main() {
        List<String> incomingOrder = new ArrayList<>();
        Map<String, Integer> scores = new HashMap<>();
        Set<String> uniqueOrders = new HashSet<>();
        incomingOrder.add("Order#1-Laptop");
        incomingOrder.add("Order#2-Phone");
        incomingOrder.add("Order#3-Laptop");
        incomingOrder.add("Order#4-Tablet");



        for (String s : incomingOrder) {
            String[] parts = s.split("-");
            uniqueOrders.add(parts[1]);
            if(!scores.containsKey(parts[1])){
                scores.put(parts[1],1);
            }
            else{
                scores.put(parts[1],scores.get(parts[1])+1);
            }
        }
        System.out.println(uniqueOrders);
        System.out.println(scores);
    }
}
