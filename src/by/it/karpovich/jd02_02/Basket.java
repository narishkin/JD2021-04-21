package by.it.karpovich.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Basket {

    private static HashMap<String, Double> goodsInBasket;
    private static final HashMap<String, Double> goodsMap = new HashMap<>(20);

    static {
        goodsMap.put("milk", 2.5);
        goodsMap.put("cheese", 7.0);
        goodsMap.put("banana", 1.99);
        goodsMap.put("strawberry", 1.29);
    }


    Basket() {
        goodsInBasket = new HashMap<>();
        int goodsNumber = Util.randomFromTo(1, goodsMap.size());
        List<String> goodsList = new ArrayList<>(goodsMap.keySet());
        for (int i = 1; i <= goodsNumber; i++) {
            int goodIndex = Util.randomUpTo(goodsList.size() - 1);
            goodsInBasket.put(goodsList.get(goodIndex), goodsMap.get(goodsList.get(goodIndex)));
            goodsList.remove(goodIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        double totalMoneySpent = 0;
        String delimiter = "";
        for (Map.Entry<String, Double> goodInBasket : goodsInBasket.entrySet()) {
            stringBuilder.append(delimiter).append(goodInBasket.getKey()).append(" for ").append(goodInBasket.getValue()).append(" $");
            totalMoneySpent = totalMoneySpent + goodInBasket.getValue();
            delimiter = ", ";
        }
        stringBuilder.append(". Total ");
        return stringBuilder.toString();
    }
}
