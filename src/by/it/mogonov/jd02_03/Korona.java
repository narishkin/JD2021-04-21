package by.it.mogonov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Korona {


    private Manager manager;
    private QueuePurchaser queuePurchaser;


    public QueuePurchaser getQueuePurchaser() {
        return queuePurchaser;
    }

    public void setQueuePurchaser(QueuePurchaser queuePurchaser) {
        this.queuePurchaser = queuePurchaser;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void start() {
        System.out.println("Korona open");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int numberCashiers = 1; numberCashiers <= 2; numberCashiers++) {
            Cashier cashier = new Cashier(numberCashiers, this);
            threadPool.submit(cashier);

        }
        threadPool.shutdown();


        int numberPurchasers = 0;
        while (manager.koronaOpened()) {
            int countPurchaserPerSecond = Randomaser.random(2);


            for (int i = 0; i < countPurchaserPerSecond && getManager().koronaOpened(); i++) {
                Purchaser purchaser = new Purchaser(++numberPurchasers, this);
                purchaser.start();

            }
            Timer.sleep(1000);
        }

        try {
            while (!threadPool.isTerminated()) {
                threadPool.awaitTermination(10, TimeUnit.HOURS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }


        System.out.println("Korona close");
    }
}





