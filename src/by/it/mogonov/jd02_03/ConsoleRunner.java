package by.it.mogonov.jd02_03;

public class ConsoleRunner {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            QueuePurchaser queuePurchaser = new QueuePurchaser();
            Manager manager = new Manager();
            Korona korona = new Korona();
            korona.setManager(manager);
            korona.setQueuePurchaser(queuePurchaser);
            korona.start();
        }
    }
}
