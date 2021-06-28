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
        for (int time = 0, j = 1; (time <= 29) && (j < Configs.MAX_PERIOD / 30) && Dispatcher.marketOpened(); time++) {
            if (time <= 29 && j % 2 != 0 || Dispatcher.currentCountBuyer >= time + 10) {
                int countBuyersIteration = RandomHelper.randomValue(0, time + 10);
                for (int i = 0; i < countBuyersIteration; i++) {
                    Buyer buyer = (idBuyer % 4 == 0 && idBuyer != 0) ? new Buyer(++idBuyer, true) : new Buyer(++idBuyer);
                    threadArrayList.add(buyer);
                    buyer.start();
                }
            } else if (time <= 29 && j % 2 == 0 && Dispatcher.currentCountBuyer <= 40 + (30 - time)) {
                int countBuyersIteration = RandomHelper.randomValue(0, 40 + (30 - time));
                for (int i = 0; i < countBuyersIteration; i++) {
                    Buyer buyer = (idBuyer % 4 == 0 && idBuyer != 0) ? new Buyer(++idBuyer, true) : new Buyer(++idBuyer);
                    threadArrayList.add(buyer);
                    buyer.start();
                }
//                System.out.println("В магазине "+ buyerList.size()+" покупателей");
            }
            TimerHelper.sleep(1000);
            if (time == 29) {
                j++;
                time = 0;
            }
        }
        for (Thread thread : threadArrayList) {
            try {
                thread.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

//        System.out.println("В магазине "+ buyerList.size()+" покупателей");

        System.out.println("Market closed");
    }

}
