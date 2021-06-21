package by.it.naryshkin.jd02_02;

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

        System.out.println("Marked opened");
        List<Thread> threads = new ArrayList<>();

        for (int numberCashiers = 1; numberCashiers <= 2; numberCashiers++) {
            Cashier cashier = new Cashier(numberCashiers);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        int periodSwitcher;
        int localFunctionTime;
        int shopperCounter = 1;


            for (int time = 1; Dispatcher.storeOpened(); time += 1) {
                periodSwitcher = (time / 30) % 2;
                localFunctionTime = time - (time / 60) * 60;
                System.out.println("TIME: " + time);

                if (periodSwitcher == 0) {
                    for (int j = 0; j <= RandomHelper.random(20 + localFunctionTime - Dispatcher.currentCountShoppersInside); j++) {
                        if (!Dispatcher.storeOpened()){
                            break;
                        }
                        Shopper shopper;
                        if (RandomHelper.random(1, 4) == 1) {
                            shopper = new Shopper(shopperCounter++, true);
                        } else {
                            shopper = new Shopper(shopperCounter++, false);
                        }
                        threads.add(shopper);
                        shopper.start();
                    }
                }
                if (periodSwitcher == 1) {
                    for (int j = 0; j <= RandomHelper.random(140 - localFunctionTime - Dispatcher.currentCountShoppersInside); j++) {
                        if (!Dispatcher.storeOpened()) {
                            break;
                        }
                        Shopper shopper;
                        if (RandomHelper.random(1, 4) == 1) {
                            shopper = new Shopper(shopperCounter++, true);
                        } else {
                            shopper = new Shopper(shopperCounter++, false);
                        }
                        threads.add(shopper);
                        shopper.start();
                    }
                }
                TimerHelper.sleep(1000);
                System.out.println("Current numbers of shoppers in the store: " + Dispatcher.currentCountShoppersInside);
                System.out.println("Current numbers of shoppers after shopping: " + Dispatcher.currentCountShoppersAfterExit);
            }


        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store closed");
    }
}
