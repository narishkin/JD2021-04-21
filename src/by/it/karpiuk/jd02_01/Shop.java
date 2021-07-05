package by.it.karpiuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Shop is opened");
        List<Customer> customers = new ArrayList<>();
        int number = 0;
        for (int time = 0; time < Config.MAX_TIME; time++) {
            int customersPerSecond = RandomHelper.random(2);
            for (int i = 0; i < customersPerSecond; i++) {
                Customer customer = new Customer(++number);
                customers.add(customer);
                customer.start();
            }
            TimerHelper.sleep(1000);
        }
        for (Customer customer : customers){
            try{
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Shop is closed");
    }
}
