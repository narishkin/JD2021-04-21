package by.it.krukouski.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    QueueBuyers() {
    }


    private final BlockingDeque<Buyer> QUEUE_BUYERS = new LinkedBlockingDeque<>(Config.QUEUE_CAPACITY);

    public int getQueueSize() {
        return QUEUE_BUYERS.size();
    }

    public Buyer poll() {
        return QUEUE_BUYERS.pollFirst();
    }

    public void add(Buyer buyer) {
        try {
            QUEUE_BUYERS.putLast(buyer);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
