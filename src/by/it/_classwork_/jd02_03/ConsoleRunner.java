package by.it._classwork_.jd02_03;

public class ConsoleRunner {


    public static void main(String[] args) {
        //запуск 1000 магазинов
        for (int i = 0; i < 1000; i++) {
            QueueBuyers queueBuyers = new QueueBuyers();
            Dispatcher dispatcher = new Dispatcher();
            Market market = new Market();
            market.setDispatcher(dispatcher);
            market.setQueueBuyers(queueBuyers);
            market.start();
        }
    }
}
