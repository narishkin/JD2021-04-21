package by.it.krukouski.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        System.out.println("Open Store");
        List<Thread> threads = new ArrayList<>();


        for (int numberCashiers=1; numberCashiers<=Config.COUNT_CASHIER; numberCashiers++){
            Cashier cashier = new Cashier(numberCashiers);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Manager.storeOpened()){
            int countBuyersPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyersPerSecond; i++) {
                if (Manager.buyersCount < Config.PLAN_BUYERS) {
                    Buyer buyer = new Buyer(++Manager.buyersCount);
                    threads.add(buyer);
                    buyer.start();
                }
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
        System.out.println("Close Store");
    }
}
