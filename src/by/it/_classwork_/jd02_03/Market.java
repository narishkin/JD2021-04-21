package by.it._classwork_.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    private Dispatcher dispatcher;
    private QueueBuyers queueBuyers;

    public QueueBuyers getQueueBuyers() {
        return queueBuyers;
    }

    public void setQueueBuyers(QueueBuyers queueBuyers) {
        this.queueBuyers = queueBuyers;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    //запуск вынес в класс ConsoleRunner
    public void start() {
        System.out.println("Market opened");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int numberCashiers = 1; numberCashiers <= 2; numberCashiers++) {
            Cashier cashier = new Cashier(numberCashiers, this);
            threadPool.submit(cashier);
        }
        threadPool.shutdown();


        int numberBuyers = 0;
        while (dispatcher.marketOpened()) {
            int countBuyerPerSecond = RandomHelper.random(2);
            //вот эта ошибка (на 2-м занятии показывал проблему, да так ее и оставил
            //тут нужно проверять на не только число покупателей но и состояние магазина
            //т.е. && dispatcher.marketOpened()
            for (int i = 0; i < countBuyerPerSecond && dispatcher.marketOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyers, this);
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
