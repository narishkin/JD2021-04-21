package by.it.nikitko.jd02_01;

import java.util.ArrayList;
import java.util.List;


public class Store {


    static List<Customer> customersInStore = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Store is open");


        for (int j = 0; j < RandomUtils.random(9,11); j++) {
            Customer customer = new Customer(++PeoplesCounter.peopleCount);
            customersInStore.add(customer);
            if (RandomUtils.random(3) == 0) {
                customer.setPensioner(true);
            }
            customer.start();
        }
        System.out.println("peopleInStore " + PeoplesCounter.peopleInStore);




        int randomMin=0;
        int randomMax=2;
        for (int i = 0; i <=30; i++) {
            int peoplesPerSec = RandomUtils.random(randomMin,randomMax);
            for (int j = 0; j < peoplesPerSec; j++) {
                Customer customer = new Customer(++PeoplesCounter.peopleCount);
                customersInStore.add(customer);
                if (RandomUtils.random(3) == 0) {
                    customer.setPensioner(true);
                }
                customer.start();
            }
            int peopleNeeded = i+10 - PeoplesCounter.peopleInStore;
            if (peopleNeeded>0) {
                randomMin = peopleNeeded;
                randomMax = peopleNeeded+2;
            }
            if (peopleNeeded<=0){
                randomMin=0;
                randomMax=0;}

            TimeUtils.sleep(1000);
            System.out.println("second " + i);
            System.out.println("peopleInStore " + PeoplesCounter.peopleInStore);
           // System.out.println("peopleNeeded " + peopleNeeded);
        }

        for (int t = 31; t <=60; t++) {
            int peoplesPerSec = RandomUtils.random(randomMin,randomMax);
            for (int j = 0; j < peoplesPerSec; j++) {
                Customer customer = new Customer(++PeoplesCounter.peopleCount);
                customersInStore.add(customer);
                if (RandomUtils.random(3) == 0) {
                    customer.setPensioner(true);
                }
                customer.start();
            }
            int peopleNeeded = 40 +(30-t) - PeoplesCounter.peopleInStore;
            if (peopleNeeded>0) {
                randomMin = peopleNeeded;
                randomMax = peopleNeeded+2;
            }
            if (peopleNeeded<=0){
                randomMin=0;
                randomMax=0;}

            TimeUtils.sleep(1000);
            System.out.println("second " + t);
            System.out.println("peopleInStore " + PeoplesCounter.peopleInStore);
            // System.out.println("peopleNeeded " + peopleNeeded);
        }




        for (Customer customer : customersInStore) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
