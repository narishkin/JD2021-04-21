package by.it.nikitko.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Printer {
    public static final Object printCheckMonitor = new Object();
    private static int sumTotalStore = 0;

    public static void printCheck(Customer currentCustomer, Cashier cashier) {
        synchronized (printCheckMonitor) {
            HashMap<String, Integer> customerGoods = currentCustomer.getCustomerGoods();
            List<String> goodsInBasket = new ArrayList<>(customerGoods.keySet());
            generateIndentation(cashier);
            System.out.println("______________________________");
            generateIndentation(cashier);
            System.out.printf("%24s check\n", currentCustomer);
            generateIndentation(cashier);
            System.out.println("Product     Price  Quant.  Sum");
            generateIndentation(cashier);
            System.out.println("______________________________");
            int sumTotal = 0;
            for (String goodsName : goodsInBasket) {
                int goodsPrice = Goods.getGoods().get(goodsName);
                int goodsQuantity = customerGoods.get(goodsName);
                int sumOneType = goodsPrice * goodsQuantity;
                sumTotal += sumOneType;
                generateIndentation(cashier);
                System.out.printf("%-10s%7d%7d%6d\n", goodsName, goodsPrice, goodsQuantity, sumOneType);
            }
            generateIndentation(cashier);
            System.out.println("______________________________");
            generateIndentation(cashier);
            System.out.printf("                    Total %4d\n", sumTotal);
            generateIndentation(cashier);
            System.out.printf("                   %11s", cashier);
            sumTotalStore += sumTotal;
            printQueueSize();
            printSumTotalStore();
        }
    }

    private static void generateIndentation(Cashier cashier) {
        for (int i = 0; i < cashier.getNumber() - 1; i++) {
            System.out.printf("                               ");
        }

    }

    public static void printQueueSize() {
        System.out.print("\r");
        for (int i = 0; i < 5; i++) {
            System.out.print("                               ");
        }
        System.out.println(" Queue size " + QueueCustomers.getSize());
    }

    public static void printSumTotalStore() {
        System.out.print("\r");
        for (int i = 0; i < 6; i++) {
            System.out.print("                            ");
        }
        System.out.println("  SumTotalStore " + sumTotalStore);
    }
}
