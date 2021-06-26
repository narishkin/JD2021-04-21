package by.it.nikitko.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCustomers {

    public static final Object MONITOR_QUEUE_CUSTOMERS = new Object();
    public QueueCustomers() {
    }
    public static final Deque <Customer > QUEUE_CUSTOMERS = new ArrayDeque<>();
    public static final Deque <Customer > QUEUE_PENSIONERS = new ArrayDeque<>();


    public static int getSize(){
        return QUEUE_CUSTOMERS.size();
    }
    public static int getSizePensioner(){
        return QUEUE_PENSIONERS.size();
    }

    public static by.it.nikitko.jd02_02.Customer poll(){
        synchronized (MONITOR_QUEUE_CUSTOMERS){
           return QUEUE_CUSTOMERS.pollFirst();
        }
    }

    public static Customer polPensioner(){
        synchronized (MONITOR_QUEUE_CUSTOMERS){
           return QUEUE_PENSIONERS.pollFirst();
        }
    }

    public static void add (Customer customer){
        synchronized (MONITOR_QUEUE_CUSTOMERS){
            QUEUE_CUSTOMERS.add(customer);
        }
    }
    public static void addPensioner (Customer customer){
        synchronized (MONITOR_QUEUE_CUSTOMERS){
            QUEUE_PENSIONERS.add(customer);
        }
    }
}
