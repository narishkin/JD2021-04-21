package by.it.krukouski.jd02_03;

public class ConsoleRunner {
    public static void main(String[] args) {
        QueueBuyers queueBuyers = new QueueBuyers();
        Manager manager = new Manager();
        Store store = new Store();
        store.setManager(manager);
        store.setQueueBuyers(queueBuyers);
        store.start();
    }
}
