package by.it.nikitko.jdtest;


public class Cashier implements Runnable {

    private final int number;

    public int getNumber() {
        return number;
    }

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
                synchronized (currentCustomer) {
                    System.out.println(this + " started service " + currentCustomer);
                    TimeUtils.sleep(RandomUtils.random(2000, 5000));
                    currentCustomer.notify();
                    System.out.println(this + " finished service " + currentCustomer);
                }
            } else {
                TimeUtils.sleep(1);
            }
        }
        System.out.println(this + " closed");
    }



}
