package by.it.stain.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

public class MySupermarket {
    public static void main(String[] args) {
        System.out.println("Opening of a supermarket");
        List<Buyer> buyers = new ArrayList<>();

        HashMap<Integer, Integer> buyerHashMap = new HashMap<>();



        int number = 0;

        for (int i = 0; i < Configuration.MAX_TIME; i++) {
            int countBuyers = RandomTimeForSupermarket.random(2);
            int countProduct = RandomTimeForSupermarket.random(5);
            for (int j = 0; j < countBuyers; j++) {
                Buyer buyer = new Buyer(++number);
                buyers.add(buyer);
                buyer.start();
                for (int k = 1; k < countProduct; k++) {
                    buyerHashMap.put(k,RandomTimeForSupermarket.random(999));



                }




            }
            TimerHelper.sleep(1000);

        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Supermarket closure");

    }
}
