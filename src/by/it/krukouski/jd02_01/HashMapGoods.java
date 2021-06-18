package by.it.krukouski.jd02_01;

import java.util.HashMap;

public class HashMapGoods {
    public static final HashMap<Integer, Integer> GOODS_MAP = new HashMap<>();

    public static void putToHashMap() {
        GOODS_MAP.put(1, 10);
        GOODS_MAP.put(2, 20);
        GOODS_MAP.put(3, 30);
        GOODS_MAP.put(4, 40);
    }

}
