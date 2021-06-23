package by.it.nakov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Store {


    public static void main(String[] args) {
        System.out.println("Store is open!");
        List<AlcoholBuyer> alcoholBuyers = new ArrayList<>();

        for (int numberOfCashier = 1; numberOfCashier <= 2; numberOfCashier++) {
            Cashier cashier = new Cashier(numberOfCashier);
            Thread thread = new Thread(cashier);
//            threads.add(thread);   ДОДЕЛАТЬ!!
        }


        int numberOfBuyers = 0;
        for (int t = 0; t < Config.MAX_TIME; t++) {
            int countBuyerPerSec = RandomHelper.random(2);
            for (int i = 0; i < countBuyerPerSec; i++) {
                AlcoholBuyer buyer = new AlcoholBuyer(++numberOfBuyers);
                alcoholBuyers.add(buyer);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        for (AlcoholBuyer buyer : alcoholBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Store closed!");
    }
}
