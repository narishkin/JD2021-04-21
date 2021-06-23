package by.it.mogonov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Korona {
    public static void main(String[] args) {
        System.out.println("Korona open");
        List<Thread> threads = new ArrayList<>();

        for (int numberCashiers = 1; numberCashiers <= 2; numberCashiers++) {
            Cashier cashier = new Cashier(numberCashiers);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();

        }


        int numberPurchasers = 0;
        while (Manager.koronaOpened()) {
            int countPurchaserPerSecond = Randomaser.random(2);
            for (int i = 0; i < countPurchaserPerSecond; i++) {
                Purchaser purchaser = new Purchaser(++numberPurchasers);
                threads.add(purchaser);
                purchaser.start();

            }
            Timer.sleep(1000);
        }
        for (Thread thread : threads) {

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }

        System.out.println("Korona close");
    }
}





