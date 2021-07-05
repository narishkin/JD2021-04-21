package by.it.stain.jd02_03;

public class Run {
    public static void main(String[] args) {

            QueueBuyers queueBuyers = new QueueBuyers();
            Dispatcher dispatcher = new Dispatcher();
            MySupermarket mySupermarket = new MySupermarket();
            mySupermarket.setDispatcher(dispatcher);
            mySupermarket.setQueueBuyers(queueBuyers);
            mySupermarket.start();


    }
}
