package by.it.krukouski.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {

    private Manager manager;
    private QueueBuyers queueBuyers;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }

    public void setQueueBuyers(QueueBuyers queueBuyers) {
        this.queueBuyers = queueBuyers;
    }


    public void start() {
        System.out.println("Open Store");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int numberCashiers = 1; numberCashiers <= 2; numberCashiers++) {
            Cashier cashier = new Cashier(numberCashiers, this);
            threadPool.submit(cashier);
        }
        threadPool.shutdown();


        int number = 0;
        while (manager.storeOpened()) {
            int countBuyersPerSecond = RandomHelper.random(2);
            for (int i = 0; i < countBuyersPerSecond; i++) {
                Buyer buyer = new Buyer(++number, this);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        try {
            while (!threadPool.isTerminated()) {
                threadPool.awaitTermination(10, TimeUnit.HOURS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Close Store");
    }
}

