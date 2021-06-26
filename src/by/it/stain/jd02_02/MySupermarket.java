package by.it.stain.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class MySupermarket {
    public static void main(String[] args) {
        System.out.println("Opening of a supermarket");
        List<Thread> threads = new ArrayList<>();

        for (int numberCashier = 1; numberCashier <= 5; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();


        }


        int numberBuyers = 0;

        while (Dispatcher.openedSupermarket()) {
            int countBuyers = RandomTimeForSupermarket.random(2);



            for (int j = 0; j < countBuyers&&Dispatcher.openedSupermarket(); j++) {


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
        System.out.println("Supermarket closure");

    }
}
