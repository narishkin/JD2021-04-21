package by.it.naryshkin.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    public static final Map<String, Integer> GOODS = new HashMap<>();
    public volatile static List<Thread> cashierThreads = new ArrayList<>();
    public static Map<String, Integer> cashiersMap = new HashMap<>();
    public static List<Shopper> shoppers = new ArrayList<>();
    public static volatile int storeSum = 0;

    static {
        GOODS.put("Jeans", 42);
        GOODS.put("T-Shirt", 21);
        GOODS.put("Hat", 63);
        GOODS.put("Shoes", 37);
    }

    public Object getStoreMonitor() {
        return this;
    }

    public static synchronized int getCashierThreadsSize() {
        return cashierThreads.size();
    }

    public static void main(String[] args) {
        System.out.println("Store opened");
        int periodSwitcher;
        int localFunctionTime;
        int shopperCounter = 1;
        int time = 0;
        while (!Dispatcher.storeClosed()) {
            int numberCashiers = getCashierThreadsSize();
            while (Dispatcher.getCurrentCashiersNumber() < (int) Math.ceil((Shopper.getDequeSize() / (double) 5)) &&
                    Dispatcher.getCurrentCashiersNumber() < 5) {
                Cashier cashier = new Cashier(numberCashiers);
                Thread thread = new Thread(cashier);
//                cashierThreads.add(thread);
                if (!cashiersMap.containsKey(cashier.toString())) {
                    cashiersMap.put(cashier.toString(), 0);
                }
                thread.start();
                Dispatcher.addCashier(thread);
                numberCashiers++;
            }
            periodSwitcher = (time / 30) % 2;
            localFunctionTime = time - (time / 60) * 60;
//            System.out.println("TIME: " + time);
            if (periodSwitcher == 0 && Dispatcher.currentCountShoppersInside < 10) {
                for (int j = 0; j <= RandomHelper.random(20 + localFunctionTime - Dispatcher.currentCountShoppersInside); j++) {
                    if (!Dispatcher.storeOpened()) {
                        break;
                    }
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
            if (periodSwitcher == 1 && Dispatcher.currentCountShoppersInside < 40) {
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
                    shoppers.add(shopper);
                    shopper.start();
                }
            }
            TimerHelper.sleep(1000);
//            System.out.println("Current numbers of shoppers in the store: " + Dispatcher.currentCountShoppersInside);
//            System.out.println("Current numbers of shoppers after shopping: " + Dispatcher.currentCountShoppersAfterExit);
            time++;

        }

        try {
            Store store = new Store();
            synchronized (store.getStoreMonitor()) {
                for (Thread thread : cashierThreads) {
                    thread.join();
                }
            }

//            System.out.println("Кассиры всё");
            for (Shopper shopper : shoppers) {
                shopper.join();
            }
//            System.out.println("Шоперы всё");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(cashiersMap.toString());
        System.out.println("Store revenue: " + cashiersMap.values().stream().reduce((s1, s2) -> s1 + s2).orElse(0));

        System.out.println("Store closed");
    }
}
