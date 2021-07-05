package by.it.nakov.jd02_03;

//public class QueueBuyers {
//    private static final Object MONITOR_QUEUE_BUYERS = new Object();
//
//    private QueueBuyers() {
//    }
//
//    private static final Deque<AlcoholBuyer> ALCOHOL_BUYERS = new ArrayDeque<>();
//
//    public static AlcoholBuyer poll() {
//        synchronized (MONITOR_QUEUE_BUYERS) {
//            return ALCOHOL_BUYERS.pollFirst();
//        }
//    }
//
//    public static void add(AlcoholBuyer alcoholBuyer) {
//        synchronized (MONITOR_QUEUE_BUYERS) {
//            ALCOHOL_BUYERS.addLast(alcoholBuyer);
//        }
//    }
//}
