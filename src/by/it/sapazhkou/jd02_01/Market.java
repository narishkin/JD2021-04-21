package by.it.sapazhkou.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        System.out.println("Market open");
        List<Buyer> buyerList = new ArrayList<>();
        int idBuyer = 0;
        for (int time = 0; time < Configs.MAX_PERIOD; time++) {
            int countBuyersIteration = RandomHelper.randomValue(2);
            for (int i = 0; i < countBuyersIteration; i++) {
                Buyer buyer = new Buyer(++idBuyer);
                buyerList.add(buyer);
                buyer.start();
//                System.out.println("В магазине "+ buyerList.size()+" покупателей");
            }
        }
//        TimerHelper.sleep(1000);
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        System.out.println("В магазине "+ buyerList.size()+" покупателей");

        System.out.println("Market closed");
    }

}
