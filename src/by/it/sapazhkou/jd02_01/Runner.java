package by.it.sapazhkou.jd02_01;

import java.lang.management.GarbageCollectorMXBean;
import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {


        HashMap good = new PriceOfGood().getGoods();
        Object bread = (Double)good.get(Good.values()[2].toString());

        System.out.println(bread.toString());

        System.out.println(good.toString());

    }
}
