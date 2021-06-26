package by.it.naryshkin.jd02_03;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {

    public static final Map<String, Integer> GOODS = new ConcurrentHashMap<>();
    public static Map<String, Integer> cashiersMap = new ConcurrentHashMap<>();
    public static AtomicInteger storeSum = new AtomicInteger(0);
    public static CopyOnWriteArrayList<Boolean> cashiers = new CopyOnWriteArrayList<>(Arrays.asList(false,false,false,false,false));

    static {
        GOODS.put("Jeans", 42);
        GOODS.put("T-Shirt", 21);
        GOODS.put("Hat", 63);
        GOODS.put("Shoes", 37);
    }

    public Store getStore() {
        return this;
    }

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        System.out.println("Store opened");


        //Склад корзин
        for (short i = 1; i <= Config.BASKET_POOL_SIZE; i++) {
            Basket.basketBlockingQueue.add(i);
        }

        int shopperCounter = 1;
        int time = 0;
        int localFunctionTime;
        int periodSwitcher;
        ExecutorService cashiersThreads = Executors.newFixedThreadPool(5);
        ExecutorService shoppersThreads = Executors.newCachedThreadPool();

        while (dispatcher.storeOpened()) {
            while (dispatcher.getCurrentCashiersNumber() < (int) Math.floor((Shopper.getDequeSize() / (double) 5) + 1) &&
                    dispatcher.getCurrentCashiersNumber() < 5) {
                int c = 0;

                for (int i = 0; i < cashiers.size(); i++) {
                    if (!cashiers.get(i)) {
                        c = i;
                        cashiers.set(i, true);
                        break;
                    }
                }
                Cashier cashier = new Cashier(c, dispatcher);
                cashiersThreads.execute(cashier);
                if (!cashiersMap.containsKey(cashier.toString())) {
                    cashiersMap.put(cashier.toString(), 0);
                }
                dispatcher.addCashier();

            }
            periodSwitcher = (time / 30) % 2;
            localFunctionTime = time - (time / 60) * 60;
//            System.out.println("TIME: " + time);
            if (periodSwitcher == 0 && dispatcher.currentCountShoppersInside.get() < 10) {
                int d = RandomHelper.random(20 + localFunctionTime - dispatcher.currentCountShoppersInside.get());
                for (int j = 0; j <= d; j++) {
                    if (dispatcher.storeClosed()) {
                        break;
                    }
                    Shopper shopper;
                    if (RandomHelper.random(1, 4) == 1) {
                        shopper = new Shopper(shopperCounter++, true, dispatcher);
                    } else {
                        shopper = new Shopper(shopperCounter++, false, dispatcher);
                    }
                    shoppersThreads.submit(shopper);
                }
            }
            if (periodSwitcher == 1 && dispatcher.currentCountShoppersInside.get() < 40) {
                int d = RandomHelper.random(140 - localFunctionTime - dispatcher.currentCountShoppersInside.get());
                for (int j = 0; j <= d; j++) {
                    if (dispatcher.storeClosed()) {
                        break;
                    }
                    Shopper shopper;
                    if (RandomHelper.random(1, 4) == 1) {
                        shopper = new Shopper(shopperCounter++, true, dispatcher);
                    } else {
                        shopper = new Shopper(shopperCounter++, false, dispatcher);
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
            cashiersThreads.awaitTermination(1, TimeUnit.HOURS);
            shoppersThreads.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Store revenue: " + cashiersMap.values().stream().reduce((s1, s2) -> s1 + s2).orElse(0));
        System.out.println("Store closed");
    }
}
