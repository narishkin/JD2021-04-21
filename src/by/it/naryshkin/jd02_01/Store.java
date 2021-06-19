package by.it.naryshkin.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    public static  Map<String, Integer> goods = new HashMap<>();

    public static void main(String[] args) {
        {
            goods.put("Jeans", 42);
            goods.put("T-Shirt", 21);
            goods.put("Hat", 63);
            goods.put("Shoes", 37);
        }

        List<Shopper> shoppers = new ArrayList<>();
        int periodSwitcher;
        int localFunctionTime;
        int shopperCounter = 1;
        System.out.println("Marked opened");
        for (int time = 1; time <= Config.MAX_TIME; time += 1) {
            periodSwitcher = (time / 30) % 2;
            localFunctionTime = time - (time / 60) * 60;
            System.out.println("TIME: " + time);
            System.out.println("Current numbers of shoppers in the store: " + Dispatcher.currentCountShoppers);
            if (periodSwitcher == 0 && Dispatcher.currentCountShoppers < localFunctionTime + 10) {
                for (int j = 0; j <= RandomHelper.random(20 + localFunctionTime - Dispatcher.currentCountShoppers); j++) {
                    Shopper shopper;
                    if (RandomHelper.random(1, 4) == 1) {
                        shopper = new Shopper(shopperCounter++, true);
                    } else {
                        shopper = new Shopper(shopperCounter++, false);
                    }
                    shoppers.add(shopper);
                    shopper.start();
                }
            }
            if (periodSwitcher == 1 && Dispatcher.currentCountShoppers < 40 + (30 - localFunctionTime)) {
                for (int j = 0; j <= RandomHelper.random(140 - localFunctionTime - Dispatcher.currentCountShoppers); j++) {
                    Shopper shopper;
                    if (RandomHelper.random(1, 4) == 1) {
                        shopper = new Shopper(shopperCounter++, true);
                    } else {
                        shopper = new Shopper(shopperCounter++, false);
                    }
                    shoppers.add(shopper);
                    shopper.start();
                }
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
