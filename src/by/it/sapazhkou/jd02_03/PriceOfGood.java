package by.it.sapazhkou.jd02_03;


import java.util.HashMap;

public class PriceOfGood extends HashMap {

    private final HashMap goods = new HashMap();

    public PriceOfGood() {
        goods.put("BREAD", 1.2);
        goods.put("MILK", 0.9);
        goods.put("BUTTER", 2.3);
        goods.put("CHEESE", 5.2);
    }

    public HashMap getGoods() {
        return goods;
    }


}


