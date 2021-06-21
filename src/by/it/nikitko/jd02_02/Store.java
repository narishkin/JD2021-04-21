package by.it.nikitko.jd02_02;

import java.util.ArrayList;
import java.util.List;


public class Store {

    private static final List<Thread> THREADS = new ArrayList<>();
    private static int randomMin = 9;
    private static int randomMax = 11;

    public static void main(String[] args) {
        System.out.println("Store is open");

        for (int numberCashier = 1; numberCashier <=Config.MAX_CASHIER_COUNT; numberCashier++) {
            Cashier cashier=new Cashier(numberCashier);
            Thread thread = new Thread(cashier);
            THREADS.add(thread);
            thread.start();

        }
        addCustomers();
        int second = 1;
        while (Manager.storeOpened()){
            addCustomers();
            correctCountCustomers(second++);
            TimeUtils.sleep(1000);
        }
        joinToMain();
        System.out.println("Store is closed");
    }

    private static void addCustomers() {
        int peoplesPerSec = RandomUtils.random(randomMin, randomMax);
        for (int j = 0; j < peoplesPerSec; j++) {
            if (Manager.peopleCount<Config.CUSTOMER_PLAN) {
                Customer customer = new Customer(++Manager.peopleCount);
                THREADS.add(customer);
                if (RandomUtils.random(3) == 0) {
                    customer.setPensioner(true);
                }
                customer.start();
            }
        }
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

    private static void joinToMain() {
        for (Thread thread : THREADS) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
