package by.it._classwork_.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {


    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int numberCashiers = 1; numberCashiers <= 2; numberCashiers++) {
            Cashier cashier = new Cashier(numberCashiers);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }


        int numberBuyers = 0;
        while (Dispatcher.marketOpened()) {
            int countBuyerPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyerPerSecond; i++) {
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

//        while (Dispatcher.currentCountBuyers > 0) {
//            Thread.onSpinWait();
//        }

        System.out.println("Market closed");
    }
}
