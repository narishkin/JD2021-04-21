package by.it.nikitko.jd02_01;

import java.util.ArrayList;
import java.util.List;


public class Store {


    private static final List<Customer> CUSTOMERS_IN_STORE = new ArrayList<>();
    private static int randomMin = 0;
    private static int randomMax = 2;

    public static void main(String[] args) {
        System.out.println("Store is open");
        addCustomers(RandomUtils.random(9, 11));

        for (int i = 0; i <= Config.TIME_WORK_STORE/4; i++) {
            int peoplesPerSec = RandomUtils.random(randomMin, randomMax);
            addCustomers(peoplesPerSec);
            correctCountCustomers(i, 10);
            TimeUtils.sleep(1000);
          //  System.out.println("second " + i);
          //  System.out.println("peopleInStore " + PeoplesCounter.peopleInStore);
        }
        for (int t = 31; t <= Config.TIME_WORK_STORE/2; t++) {
            int peoplesPerSec = RandomUtils.random(randomMin, randomMax);
            addCustomers(peoplesPerSec);
            correctCountCustomers(40, 30 - t);
            TimeUtils.sleep(1000);
        }
        for (int i = 61; i <= Config.TIME_WORK_STORE/4*3; i++) {
            int peoplesPerSec = RandomUtils.random(randomMin, randomMax);
            addCustomers(peoplesPerSec);
            correctCountCustomers(i, 10);
            TimeUtils.sleep(1000);
        }
        for (int t = 91; t <= Config.TIME_WORK_STORE; t++) {
            int peoplesPerSec = RandomUtils.random(randomMin, randomMax);
            addCustomers(peoplesPerSec);
            correctCountCustomers(130, -t);
            TimeUtils.sleep(1000);
        }

        joinToMain();
        System.out.println("Store is closed");
    }

    private static void correctCountCustomers(int i, int i2) {
        int peopleNeeded = i + i2 - PeoplesCounter.peopleInStore;
        if (peopleNeeded > 0) {
            randomMin = peopleNeeded;
            randomMax = peopleNeeded + 2;
        }
        if (peopleNeeded <= 0) {
            randomMin = 0;
            randomMax = 0;
        }
    }

    private static void addCustomers(int peoplesPerSec) {
        for (int j = 0; j < peoplesPerSec; j++) {
            Customer customer = new Customer(++PeoplesCounter.peopleCount);
            CUSTOMERS_IN_STORE.add(customer);
            if (RandomUtils.random(3) == 0) {
                customer.setPensioner(true);
            }
            customer.start();
        }
    }

    private static void joinToMain() {
        for (Customer customer : CUSTOMERS_IN_STORE) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
