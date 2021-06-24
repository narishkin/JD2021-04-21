package by.it.krukouski.jd02_03;

public class Cashier implements Runnable {

    private final int number;

    private final Store store;

    public Cashier(int number, Store store) {
        this.number = number;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!store.getManager().storeClosed()) {
            Buyer buyer = store.getQueueBuyers().poll();
            if (buyer != null) {
                System.out.println(this + " started service " + buyer);
                int timeout = RandomHelper.random(2000, 5000);
                TimerHelper.sleep(timeout);
                synchronized (buyer.getMonitor()) {
                    buyer.setWaitFlag(false);
                    buyer.notify();
                }
                System.out.println(this + " finished service " + buyer);
            } else {
                // thinking
                System.out.println(this + " sleep");
                TimerHelper.sleep(1);
            }
        }
        System.out.println(this + " closed");

    }

    @Override
    public String toString() {
        return String.format("Cashier №%d ", number);
    }
}
