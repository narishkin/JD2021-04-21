package by.it.sapazhkou.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {


    private Dispatcher dispatcher;
    private QueueBuyers queueBuyers;

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }

    public void setQueueBuyers(QueueBuyers queueBuyers) {
        this.queueBuyers = queueBuyers;
    }


    public static void main(String[] args) {
        mainA(args);
    }

    public static void mainA(String[] args) {
        System.out.println("Market open");
        QueueBuyers queueBuyers = new QueueBuyers();
        Dispatcher dispatcher = new Dispatcher();
        Market market = new Market();
        market.setDispatcher(dispatcher);
        market.setQueueBuyers(queueBuyers);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int idCasheir = 1; idCasheir <= 2; idCasheir++) {
            Cashier cashier = new Cashier(idCasheir, market);
            threadPool.submit(cashier);
        }
        threadPool.shutdown();

        int idBuyer = 0;
        while (market.getDispatcher().marketOpened()) {
            int countBuyersIteration = RandomHelper.randomValue(2);
            for (int i = 0; i < countBuyersIteration; i++) {
                Buyer buyer = (idBuyer % 4 == 0 && idBuyer != 0) ? new Buyer(++idBuyer, market, true) : new Buyer(++idBuyer,market);
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


        System.out.println("Market closed");
    }

}
