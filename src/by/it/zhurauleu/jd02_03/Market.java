package by.it.zhurauleu.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void main(String[] args) {
        System.out.println("Market opened");

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int cashiersNumber = 1; cashiersNumber <= 2; cashiersNumber++) {
            threadPool.execute(new Cashier(cashiersNumber));
        }
        threadPool.shutdown();

        int countBuyers = 0;
        while (Dispatcher.marketOpened()) {
            int countBuyersPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyersPerSecond && Dispatcher.marketOpened(); i++) {
                Buyer buyer = new Buyer(++countBuyers);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }

        while (!threadPool.isTerminated()) {
            try {
                threadPool.awaitTermination(10, TimeUnit.HOURS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
