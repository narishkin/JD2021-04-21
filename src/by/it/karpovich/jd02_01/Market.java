package by.it.karpovich.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Buyer> buyerList = new ArrayList<>();

        Map<String, Integer> goods = new HashMap<>();
        Goods.goods.put("banana", 3);
        Goods.goods.put("strawberry", 14);
        Goods.goods.put("pineapple", 8);
        Goods.goods.put("orange", 6);
        Goods.goods.put("mango", 7);
        Goods.goods.put("watermelon", 9);
        Goods.goods.put("coconut", 5);

        for (int i = 0; i < 120; i++) {
            int currentCount = Helper.random(2);
            for (int j = 0; j <= currentCount; j++) {
                Buyer buyer = new Buyer(++Dispatcher.counterBuyer);
                buyerList.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            buyer.join();
        }
        System.out.println("Market closed");
    }
}
