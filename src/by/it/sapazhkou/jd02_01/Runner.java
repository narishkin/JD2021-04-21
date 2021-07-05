package by.it.sapazhkou.jd02_01;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {

        HashMap good = new PriceOfGood().getGoods();
        Object bread = (Double)good.get(GoodEnum.values()[2].toString());
        GoodEnum value = GoodEnum.values()[0];
        value.name();

        System.out.println("продукт "+ GoodEnum.values()[2].name() +" цена "  + bread.toString());

        System.out.println(good.toString());
    }
}
