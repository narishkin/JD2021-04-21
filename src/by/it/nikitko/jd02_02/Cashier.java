package by.it.nikitko.jd02_02;

public class Cashier implements Runnable {

    private final int number;
    private boolean flagWait;

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    public Cashier(int number) {
        this.number = number;
    }

    Object getMonitor() {
        return this;
    }

    @Override
    public String toString() {
        return String.format("Cashier # %d ", number);
    }


    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Manager.storeClosed()) {
            Customer currentCustomer = QueueCustomers.poll();
            if (currentCustomer != null) {
                System.out.println(this + " started service " + currentCustomer);
                TimeUtils.sleep(RandomUtils.random(2000, 5000));
                synchronized (currentCustomer.getMonitor()) {
                    currentCustomer.setFlagWait(false);
                    currentCustomer.notify();
                }
                System.out.println(this + " finished service " + currentCustomer);
            } else {
                synchronized (this) {
                    ClosedCashiers.add(this);
                    flagWait = true;
                    System.out.println(this + " closed");
                    try {
                        this.wait();
                        if (Manager.getServedCustomersCount() < 100) {
                            System.out.println(this + "opened");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        while (ClosedCashiers.getSize() > 0) {
            Cashier currentCashier = ClosedCashiers.poll();
            synchronized (currentCashier.getMonitor()) {
                currentCashier.setFlagWait(false);
                currentCashier.notify();
            }
        }
        System.out.println(this + " closed");
    }
}
