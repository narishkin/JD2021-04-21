package by.it.stain.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MySupermarket {
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





    public void start() {
        System.out.println("Opening of a supermarket");
        ExecutorService thread = Executors.newFixedThreadPool(5);

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier, this);
            thread.submit(cashier);


        }
        thread.shutdown();


        int numberBuyers = 0;

        while (dispatcher.openedSupermarket()) {
            int countBuyers = RandomTimeForSupermarket.random(2);



            for (int j = 0; j < countBuyers && dispatcher.openedSupermarket(); j++) {


                Buyer buyer = new Buyer(++numberBuyers,this);
                buyer.start();




            }
            TimerHelper.sleep(1000);

        }
        try{
            while (!thread.isTerminated()){
                thread.awaitTermination(10, TimeUnit.HOURS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Supermarket closure");

    }
}
