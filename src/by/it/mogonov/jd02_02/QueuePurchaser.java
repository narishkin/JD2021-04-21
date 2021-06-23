package by.it.mogonov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueuePurchaser {
    public static final Object MONITOR_QUEUE_PURCHASERS= new Object();
    private QueuePurchaser(){

    }
    public static final Deque<Purchaser>PURCHASERS=new ArrayDeque<>();
    public static Purchaser pool(){
        synchronized (MONITOR_QUEUE_PURCHASERS){
            return PURCHASERS.pollFirst();
        }
    }

    public static void add(Purchaser purchaser){
        synchronized (MONITOR_QUEUE_PURCHASERS){
            PURCHASERS.addLast(purchaser);
        }
    }
}
