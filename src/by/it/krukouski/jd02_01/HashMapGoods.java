package by.it.krukouski.jd02_01;

import java.util.HashMap;

public class HashMapGoods {
    public static final HashMap<String, Integer> GOODS_MAP = new HashMap<>();

    static {
        GOODS_MAP.put("Bread", 10);
        GOODS_MAP.put("Orange", 20);
        GOODS_MAP.put("Water", 30);
        GOODS_MAP.put("Apple", 40);
    }

    public static HashMap<String, Integer> getHashMap(){
        return GOODS_MAP;
    }

}
