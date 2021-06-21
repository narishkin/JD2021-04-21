package by.it.nikitko.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Printer {

    public static void printCheck(Customer currentCustomer) {
        HashMap<String, Integer> customerGoods = currentCustomer.getCustomerGoods();
        List<String> goodsInBasket = new ArrayList<>(customerGoods.keySet());
        System.out.println("__________________________________");
        System.out.printf("%28s check\n",currentCustomer);
        System.out.println("   Product    Price   Quant.   Sum");
        System.out.println("__________________________________");
        int sumTotal = 0;
        for (String goodsName : goodsInBasket) {
            int goodsPrice = Goods.getGoods().get(goodsName);
            int goodsQuantity = customerGoods.get(goodsName);
            int sumOneType = goodsPrice * goodsQuantity;
            sumTotal += sumOneType;
            System.out.printf("%10s%9d%8d%7d\n", goodsName, goodsPrice, goodsQuantity, sumOneType);
        }
        System.out.println("__________________________________");
        System.out.printf("                        Total %4d\n", sumTotal);

    }
}
