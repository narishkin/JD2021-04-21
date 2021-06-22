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
                if (currentCustomer.isPensioner()) {
                    TimeUtils.sleep(RandomUtils.random(3000, 7500));
                } else {
                    TimeUtils.sleep(RandomUtils.random(2000, 5000));
                }
                Printer.printCheck(currentCustomer);
                synchronized (currentCustomer.getMonitor()) {
                    currentCustomer.setFlagWait(false);
                    currentCustomer.notify();
                }
                System.out.println(this + " finished service " + currentCustomer);
            } else {
                cashierWait();
            }
        }
        while (ClosedCashiers.getSize() > 0) {
            Cashier currentCashier = ClosedCashiers.poll();
            if (currentCashier != null) {
                synchronized (currentCashier.getMonitor()) {
                    currentCashier.setFlagWait(false);
                    currentCashier.notify();
                }
            }
        }
        System.out.println(this + " closed");
    }

    private void cashierWait() {
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
