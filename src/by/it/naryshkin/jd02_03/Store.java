package by.it.naryshkin.jd02_03;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    public static final Map<String, Integer> GOODS = new ConcurrentHashMap<>();
    public static Map<String, Integer> cashiersMap = new ConcurrentHashMap<>();
    public static AtomicInteger storeSum = new AtomicInteger(0);

    static {
        GOODS.put("Jeans", 42);
        GOODS.put("T-Shirt", 21);
        GOODS.put("Hat", 63);
        GOODS.put("Shoes", 37);
    }

    public Object getStoreMonitor() {
        return this;
    }

    public static void main(String[] args) {
        System.out.println("Store opened");
        //Склад корзин
        for (short i = 1; i <= Config.BASKET_POOL_SIZE; i++) {
            Basket.basketBlockingQueue.add(i);
        }

        int shopperCounter = 1;
        int time = 0;
        int localFunctionTime;
        int periodSwitcher;
        ExecutorService cashiersThreads =  Executors.newFixedThreadPool(5);
        ExecutorService shoppersThreads =  Executors.newCachedThreadPool();

        while (Dispatcher.storeOpened()) {
            while (Dispatcher.getCurrentCashiersNumber() < (int) Math.floor((Shopper.getDequeSize() / (double) 5) + 1) &&
                    Dispatcher.getCurrentCashiersNumber() < 5) {
                Cashier cashier = new Cashier(Dispatcher.getCurrentCashiersNumber());
                cashiersThreads.submit(cashier);
                if (!cashiersMap.containsKey(cashier.toString())) {
                    cashiersMap.put(cashier.toString(), 0);
                }
                Dispatcher.addCashier();
            }
            periodSwitcher = (time / 30) % 2;
            localFunctionTime = time - (time / 60) * 60;
//            System.out.println("TIME: " + time);
            if (periodSwitcher == 0 && Dispatcher.currentCountShoppersInside.get() < 10) {
                for (int j = 0; j <= RandomHelper.random(20 + localFunctionTime - Dispatcher.currentCountShoppersInside.get()); j++) {
                    if (Dispatcher.storeClosed()) {
                        break;
                    }
                    Shopper shopper;
                    if (RandomHelper.random(1, 4) == 1) {
                        shopper = new Shopper(shopperCounter++, true);
                    } else {
                        shopper = new Shopper(shopperCounter++, false);
                    }
                    shoppersThreads.submit(shopper);
                }
            }
            if (periodSwitcher == 1 && Dispatcher.currentCountShoppersInside.get() < 40) {
                for (int j = 0; j <= RandomHelper.random(140 - localFunctionTime - Dispatcher.currentCountShoppersInside.get()); j++) {
                    if (Dispatcher.storeClosed()) {
                        break;
                    }
                    Shopper shopper;
                    if (RandomHelper.random(1, 4) == 1) {
                        shopper = new Shopper(shopperCounter++, true);
                    } else {
                        shopper = new Shopper(shopperCounter++, false);
                    }
                    shoppersThreads.submit(shopper);
                }
            }
            TimerHelper.sleep(1000);
            time++;

        }
        cashiersThreads.shutdown();
        shoppersThreads.shutdown();
        try {
            cashiersThreads.awaitTermination(1,TimeUnit.HOURS);
            shoppersThreads.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Store revenue: " + cashiersMap.values().stream().reduce((s1, s2) -> s1 + s2).orElse(0));
        System.out.println("Store closed");
    }
}
