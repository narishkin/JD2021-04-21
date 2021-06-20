package by.it.nikitko.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCustomers {

    public static final Object MONITOR_QUEUE_CUSTOMERS = new Object();
    public QueueCustomers() {
    }
    public static final Deque <Customer > QUEUE_CUSTOMERS = new ArrayDeque<>();


    public static int getSize(){
        return QUEUE_CUSTOMERS.size();
    }
    public static Customer poll(){
        synchronized (MONITOR_QUEUE_CUSTOMERS){
           return QUEUE_CUSTOMERS.pollFirst();
        }
    }

    public static void add (Customer customer){
        synchronized (MONITOR_QUEUE_CUSTOMERS){
            QUEUE_CUSTOMERS.add(customer);
        }
    }
}
