package by.it.mogonov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueuePurchaser {

    public QueuePurchaser() {

    }

    private final BlockingDeque<Purchaser> PURCHASERS = new LinkedBlockingDeque<>(Conctant.QUEUE_CAPACITY);

    public Purchaser poll() { return PURCHASERS.pollFirst(); }


    public void add(Purchaser purchaser) {
        try {
            PURCHASERS.putLast(purchaser);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
