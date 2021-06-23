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
            System.out.printf("%22s receipt\n", currentCustomer);
            generateIndentation(cashier);
            System.out.println("Item        Price   Qty Amount");
            generateIndentation(cashier);
            System.out.println("______________________________");
            int sumTotal = 0;
            for (String goodsName : goodsInBasket) {
                int goodsPrice = Goods.getGoods().get(goodsName);
                int goodsQuantity = customerGoods.get(goodsName);
                int amount = goodsPrice * goodsQuantity;
                sumTotal += amount;
                generateIndentation(cashier);
                System.out.printf("%-10s%7d%6d%7d\n", goodsName, goodsPrice, goodsQuantity, amount);
            }
            generateIndentation(cashier);
            System.out.println("______________________________");
            generateIndentation(cashier);
            System.out.printf("                    Total %4d\n", sumTotal);
            generateIndentation(cashier);
            System.out.printf("                   %11s\n", cashier);
            sumTotalStore += sumTotal;
            printInformation();

        }
    }

    private static void generateIndentation(Cashier cashier) {
        for (int i = 0; i < cashier.getNumber() - 1; i++) {
            System.out.print("                               ");
        }

    }

    public static void printInformation() {
        System.out.print("\r");
        for (int i = 0; i < 5; i++) {
            System.out.print("                               ");
        }
        System.out.printf(" Queue size: %-3d   Total sum store: %6d\n",QueueCustomers.getSize(),sumTotalStore);
    }


}
