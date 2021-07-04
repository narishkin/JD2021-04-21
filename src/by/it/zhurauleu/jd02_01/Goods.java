package by.it.zhurauleu.jd02_01;

import java.util.HashMap;

public class Goods {
    private static final HashMap<String, Integer> GOODS = new HashMap<>();

    static {
        GOODS.put("Pepsi", 1);
        GOODS.put("Coca-cola", 2);
        GOODS.put("Gorilla", 3);
        GOODS.put("Fanta", 4);
        GOODS.put("Mirinda", 5);
        GOODS.put("Sprite", 6);
        GOODS.put("Snickers", 7);
        GOODS.put("Mars", 8);
        GOODS.put("MilkyWay", 9);
    }

    public static HashMap<String, Integer> getGoods(){
        return GOODS;
    }

}

