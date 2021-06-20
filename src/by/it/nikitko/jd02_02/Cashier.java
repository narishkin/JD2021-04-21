package by.it.nikitko.jd02_02;

public class Cashier implements Runnable {

    private final int number;

    public Cashier(int number) {
        this.number = number;
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
            if (currentCustomer!=null){
                System.out.println(this+" started service "+currentCustomer);
                TimeUtils.sleep(RandomUtils.random(2000,5000));
                synchronized (currentCustomer.getMonitor()){
                    currentCustomer.setFlagWait(false);
                    currentCustomer.notify();
                }
                System.out.println("finished service "+currentCustomer);
            }
            else{
                TimeUtils.sleep(1);
            }
        }
        System.out.println(this+" closed");
    }
}
