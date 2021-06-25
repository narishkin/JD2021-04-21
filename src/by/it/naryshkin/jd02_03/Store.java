package by.it.naryshkin.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Store opened");
        //Склад корзин
        for (short i = 1; i <= Config.BASKET_POOL_SIZE; i++) {
            Basket.basketBlockingQueue.add(i);

        }
//        for (Short aShort : Basket.basketBlockingQueue) {
//            System.out.println(aShort);
//        }

        int shopperCounter = 1;
        int time = 0;
        int localFunctionTime;
        int periodSwitcher;
        ExecutorService cashiersThreads =  Executors.newFixedThreadPool(5);
        ExecutorService shoppersThreads =  Executors.newCachedThreadPool();

        while (!Dispatcher.storeClosed()) {
            while (Dispatcher.getCurrentCashiersNumber() < (int) Math.floor((Shopper.getDequeSize() / (double) 5) + 1) &&
                    Dispatcher.getCurrentCashiersNumber() < 5) {
                Cashier cashier = new Cashier(getCashierThreadsSize());
//                cashiersThreads.submit(cashier);
                Thread thread = new Thread(cashier);
                if (!cashiersMap.containsKey(cashier.toString())) {
                    cashiersMap.put(cashier.toString(), 0);
                }
                thread.start();
                Dispatcher.addCashier(thread);
            }
            periodSwitcher = (time / 30) % 2;
            localFunctionTime = time - (time / 60) * 60;
//            System.out.println("TIME: " + time);
            if (periodSwitcher == 0 && Dispatcher.currentCountShoppersInside.get() < 10) {
                for (int j = 0; j <= RandomHelper.random(20 + localFunctionTime - Dispatcher.currentCountShoppersInside.get()); j++) {
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
//                    shoppersThreads.submit(shopper);
                }
            }
            if (periodSwitcher == 1 && Dispatcher.currentCountShoppersInside.get() < 40) {
                for (int j = 0; j <= RandomHelper.random(140 - localFunctionTime - Dispatcher.currentCountShoppersInside.get()); j++) {
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
//                    shopper.start();
                    shoppersThreads.submit(shopper);
                }
            }
            TimerHelper.sleep(1000);
//            System.out.println("Current numbers of shoppers in the store: " + Dispatcher.currentCountShoppersInside);
//            System.out.println("Current numbers of shoppers after shopping: " + Dispatcher.currentCountShoppersAfterExit);
            time++;

        }
        cashiersThreads.shutdown();
        shoppersThreads.shutdown();

        try {
            for (Shopper shopper : shoppers) {
                shopper.join();
            }

            for (Thread thread : cashierThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        for (Short aShort : Basket.basketBlockingQueue) {
//            System.out.println(aShort);
//        }
        System.out.println("Store revenue: " + cashiersMap.values().stream().reduce((s1, s2) -> s1 + s2).orElse(0));
        System.out.println("Store closed");
    }
}
