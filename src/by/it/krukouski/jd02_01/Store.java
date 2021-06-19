package by.it.krukouski.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        System.out.println("Open Store");
        List<Buyer> buyerList = new ArrayList<>();
        int number = 0;
        for (int time = 0; time < Config.MAX_TIME; time++) {
            int countBuyersPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyersPerSecond; i++) {
                Buyer buyer = new Buyer(++number);
                buyerList.add(buyer);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Close Store");
    }
}
