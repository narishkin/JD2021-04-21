package by.it.mogonov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Korona {
    public static void main(String[] args) {
        System.out.println("Korona open");
        List<Purchaser> purchasers=new ArrayList<>();
        int number=0;
        for (int time = 0; time < Conctant.MAX_TIME; time++) {
            int countPurchaserPerSecond=Randomaser.random(2);
            for (int i = 0; i < countPurchaserPerSecond; i++) {
                Purchaser purchaser= new Purchaser(++number);
                purchasers.add(purchaser);
                purchaser.start();


            }
            Timer.sleep(1000);
        }
       for (Purchaser purchaser:purchasers){
           try {
               purchaser.join();
           }catch (InterruptedException e){
               e.printStackTrace();
           }

        }
        System.out.println("Korona close");
    }
}
