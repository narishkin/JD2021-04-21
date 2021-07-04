package by.it.zhurauleu.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private final static BlockingDeque<Buyer> BUYERS = new LinkedBlockingDeque<>(Config.MAX_BUYERS_IN_QUEUE);

    private QueueBuyers() {
    }


    public static Buyer poll() {
        return BUYERS.pollFirst();
    }

    public static void add(Buyer buyer) {
        try {
            BUYERS.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
