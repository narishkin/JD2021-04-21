package by.it.zhurauleu.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int countCashiers = 1; countCashiers <= 2; countCashiers++) {
            Cashier cashier = new Cashier(countCashiers);
            threads.add(cashier);
            cashier.start();
        }

        int countBuyers = 0;
        while(Dispatcher.marketOpened()){
            int countBuyersPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyersPerSecond; i++) {
                if (!Dispatcher.marketOpened()){
                    System.out.println("Plan complete");
                    break;
                }
                Buyer buyer = new Buyer(++countBuyers);
                threads.add(buyer);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
