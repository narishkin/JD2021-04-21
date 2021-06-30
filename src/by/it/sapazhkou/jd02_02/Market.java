package by.it.sapazhkou.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        mainA(args);
    }

    public static void mainA(String[] args) {
        System.out.println("Market open");
        List<Thread> threadArrayList = new ArrayList<>();

        for (int idCasheir = 1; idCasheir <= 2; idCasheir++) {
            Cashier cashier = new Cashier(idCasheir);
            Thread thread = new Thread(cashier);
            threadArrayList.add(thread);
            thread.start();
        }

        int idBuyer = 0;
        while (Dispatcher.marketOpened()) {
            int countBuyersIteration = RandomHelper.randomValue(2);
            for (int i = 0; i < countBuyersIteration; i++) {
                Buyer buyer = (idBuyer % 4 == 0 && idBuyer != 0) ? new Buyer(++idBuyer, true) : new Buyer(++idBuyer);
                threadArrayList.add(buyer);
                buyer.start();
            }
        }
        for (Thread thread : threadArrayList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Market closed");
    }

}
