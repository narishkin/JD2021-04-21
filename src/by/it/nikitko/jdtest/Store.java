package by.it.nikitko.jdtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;


public class Store {

   private static ForkJoinPool threadFJP = new ForkJoinPool();

    private static int randomMin = 0;
    private static int randomMax = 2;

    public static void main(String[] args) {
        System.out.println("Store is open");
        for (int numberCashier = 1; numberCashier <= Config.MAX_CASHIER_COUNT; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            threadFJP.submit(cashier);
        }
    //    int second = 1;
        while (Manager.storeOpened()) {
            int peoplesPerSec = RandomUtils.random(randomMin, randomMax);
            for (int j = 0; j < peoplesPerSec; j++) {
                if (Manager.peopleCount < Config.CUSTOMER_PLAN) {
                    Customer customer = new Customer(++Manager.peopleCount);
                    threadFJP.submit(customer);
                }
            }
            TimeUtils.sleep(1000);
        }

        threadFJP.shutdown();
        while (!threadFJP.isTerminated()) {
            try {
                threadFJP.awaitTermination(10, TimeUnit.HOURS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Store is closed");

    }



    private static void correctCountCustomers(int t) {
        int i = 10;

        if (t > Config.TIME_WORK_STORE / 4 & t <= Config.TIME_WORK_STORE / 2) {
            i = 70;
            t = -t;
        }
        if (t > Config.TIME_WORK_STORE / 2 & t <= Config.TIME_WORK_STORE / 4 * 3) {
            i = -50;
        }
        if (t > Config.TIME_WORK_STORE / 4 * 3 & t <= Config.TIME_WORK_STORE) {
            i = 130;
            t = -t;
        }

        int peopleNeeded = i + t - Manager.peopleInStore + 1;
        if (peopleNeeded > 0) {
            randomMin = peopleNeeded;
            randomMax = peopleNeeded + 2;
        }
        if (peopleNeeded <= 0) {
            randomMin = 0;
            randomMax = 0;
        }
    }


}
