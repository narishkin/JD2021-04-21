package by.it.stain.jd02_02;


import java.util.HashMap;
import java.util.Map;


public class ShoppingList {


    private static final Map<String, Integer> SHOPPING_LIST = new HashMap<>();

    static {
        SHOPPING_LIST.put("Milk", 123);
        SHOPPING_LIST.put("Bread", 98);
        SHOPPING_LIST.put("Salt", 27);
        SHOPPING_LIST.put("Water", 64);
    }

   public static Map<String, Integer> getPurchases(){ return SHOPPING_LIST;}




}



