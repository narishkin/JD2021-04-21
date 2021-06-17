package by.it.nikitko.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    public static void main(String[] args) {
        Map<String, Integer> goods = new HashMap<>();
        goods.put("Whiskey", 160);
        goods.put("Beer", 12);
        goods.put("Vodka", 73);
        goods.put("Minskaya-4", 8);

        System.out.println("Store is open");
        int peopleCount = 0;
        List<Customer> customersInStore = new ArrayList<>();
        for (int i = 0; i < Config.TIME_WORK_STORE; i++) {
            int peoplesPerSec = RandomUtils.random(2);
            for (int j = 0; j < peoplesPerSec; j++) {
                Customer customer = new Customer(peopleCount++);
                customersInStore.add(customer);
            }
            for (Customer customer : customersInStore) {
                try {
                    customer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            TimeUtils.sleep(1000);
        }
        System.out.println("Store is closed");
    }
}
