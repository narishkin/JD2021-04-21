package by.it.nikitko.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Market {


    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        ForkJoinPool threadFJP = new ForkJoinPool();
        for (int numberCashiers = 1; numberCashiers <= 2; numberCashiers++) {
            Cashier cashier = new Cashier(numberCashiers);
            threadFJP.submit(cashier);
        }
threadFJP.shutdown();

        int numberBuyers = 0;
        while (Dispatcher.marketOpened()) {
            int countBuyerPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyerPerSecond && Dispatcher.marketOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyers);
                threads.add(buyer);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!threadFJP.isTerminated()) {
            try {
                threadFJP.awaitTermination(10, TimeUnit.HOURS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market closed");
    }
}
