package by.it.krukouski.jd02_03;

public class Cashier implements Runnable {

    private final int number;

    private final Store store;

    public Cashier(int number, Store store) {
        this.number = number;
        this.store = store;
    }

    Object getMonitor() {
        return this;
    }

    private boolean waitFlag;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
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
                synchronized (this) {
                    QueueCashiers.add(this);
                    waitFlag = true;
                    System.out.println(this + "closed");
                    try {
                        this.wait();
                        if (store.getManager().getCompleteCountBuyers() < 100) {
                            System.out.println(this + "opened");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        while (QueueCashiers.getQueueSize() > 0) {
            Cashier cashier = QueueCashiers.poll();
            if (cashier != null) {
                synchronized (cashier.getMonitor()) {
                    cashier.setWaitFlag(false);
                    cashier.notify();
                }
            }
            System.out.println(this + " closed");
        }

    }

    @Override
    public String toString() {
        return String.format("Cashier № %d", number);
    }
}
