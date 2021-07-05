package by.it.zhurauleu.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static int countBuyers = 0;

    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();

        for (int time = 0; time < Config.MAX_TIME; time++) {
            int countBuyersPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyersPerSecond; i++) {
                Buyer buyer = new Buyer(++countBuyers);
                buyers.add(buyer);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
