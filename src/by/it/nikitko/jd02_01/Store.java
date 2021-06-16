package by.it.nikitko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static void main(String[] args) {
        System.out.println("Store is open");
        int peopleCount =0;
      //  List <Customer> customersInStore = new ArrayList<>();
        for (int i = 0; i < Config.TIME_WORK_STORE; i++) {
           int peoplesPerSec = RandomUtils.random(2);
            for (int j = 0; j < peoplesPerSec; j++) {
                Customer customer = new Customer(peopleCount++);
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
