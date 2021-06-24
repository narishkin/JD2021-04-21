package by.it.nikitko.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCustomers {


    public QueueCustomers() {
    }


    public static final BlockingDeque<Customer> QUEUE_PENSIONERS = new LinkedBlockingDeque<>(30);
    public static final BlockingDeque<Customer> QUEUE_CUSTOMERS = new LinkedBlockingDeque<>(30-getSizePensioner());


    public static int getSize(){
        return QUEUE_CUSTOMERS.size();
    }
    public static int getSizePensioner(){
        return QUEUE_PENSIONERS.size();
    }

    public static Customer poll(){
        return QUEUE_CUSTOMERS.pollFirst();
    }

    public static Customer polPensioner(){
        return QUEUE_PENSIONERS.pollFirst();
    }

    public static void add (Customer customer){
        try {
            QUEUE_CUSTOMERS.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void addPensioner (Customer customer){
        try {
            QUEUE_PENSIONERS.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
