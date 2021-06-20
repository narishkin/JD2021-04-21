package by.it.krukouski.jd02_02;

public class Cashier implements Runnable {

    private final int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!CounterBuyers.storeClosed()) {
            Buyer buyer = QueueBuyers.poll();
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
                // think
            }
        }
        System.out.println(this + "closed");

    }

    @Override
    public String toString() {
        return String.format("Cashier № " + number);
    }
}
