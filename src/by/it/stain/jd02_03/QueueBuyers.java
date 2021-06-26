package by.it.stain.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {


    public QueueBuyers() {
    }

    private final BlockingDeque<Buyer> BUYERS = new LinkedBlockingDeque<>(Configuration.QUEUE_CAPACITY);

    public Buyer poll() {

        return BUYERS.pollFirst();

    }

    public void add(Buyer buyer) {
        try {
            BUYERS.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
