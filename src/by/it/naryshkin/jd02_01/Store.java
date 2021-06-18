package by.it.naryshkin.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    public static Map<String, Integer> goods = new HashMap<>();

    public static void main(String[] args) {
        {
            goods.put("Jeans", 42);
            goods.put("T-Shirt", 21);
            goods.put("Hat", 63);
            goods.put("Shoes", 37);
        }

        List<Shopper> shoppers = new ArrayList<>();
        System.out.println("Marked opened");
        int shopperCounter = 1;
        for (int time = 1; time <= Config.MAX_TIME; time += 1) {
            int currentShoppersPerSecond = RandomHelper.random(2);
            for (int j = 0; j <= currentShoppersPerSecond; j++) {
                Shopper shopper;
                if (RandomHelper.random(1, 4) == 1) {
                    shopper = new Shopper(shopperCounter++, true);
                } else {
                    shopper = new Shopper(shopperCounter++, false);
                }
                shoppers.add(shopper);
                shopper.start();
            }
            TimerHelper.sleep(1000);
        }

        try {
            for (Shopper shopper : shoppers) {
                shopper.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store closed");
    }
}
