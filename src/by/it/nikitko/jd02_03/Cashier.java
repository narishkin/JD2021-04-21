package by.it.nikitko.jd02_03;


public class Cashier implements Runnable {

    private final int number;

    public int getNumber() {
        return number;
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
            Customer currentCustomer;
            if (QueueCustomers.getSizePensioner() > 0) {
                currentCustomer = QueueCustomers.polPensioner();
            } else {
                currentCustomer = QueueCustomers.poll();
            }
            if (currentCustomer != null) {
                serveCustomer(currentCustomer);
            } else {
                cashierWait();
            }
        }
        System.out.println(this + " closed");
    }

    private void serveCustomer(Customer currentCustomer) {
        System.out.println(this + " started service " + currentCustomer);
        if (currentCustomer.isPensioner()) {
            TimeUtils.sleep(RandomUtils.random(3000, 7500));
        } else {
            TimeUtils.sleep(RandomUtils.random(2000, 5000));
        }
        Printer.printCheck(currentCustomer, this);
        synchronized (currentCustomer.getMonitor()) {
            currentCustomer.setFlagWait(false);
            currentCustomer.notify();
        }
        System.out.println(this + " finished service " + currentCustomer);
    }


    private void cashierWait() {
        synchronized (this) {
            ClosedCashiers.add(this);
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
