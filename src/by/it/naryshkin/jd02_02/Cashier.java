package by.it.naryshkin.jd02_02;

public class Cashier implements Runnable {
    private final int number;

    public Cashier(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.storeClosed()){
            Shopper currentShopper = QueueShoppers.poll();
            if (currentShopper != null){
                System.out.println(this + "started cash operation " + currentShopper);
                int cashingTime = RandomHelper.random(2000,5000);
                TimerHelper.sleep(cashingTime);
                synchronized (currentShopper.getMonitor()){
                    currentShopper.setWaitPointer(false);
                    currentShopper.notify();
                }
                System.out.println(this + "finished service " + currentShopper);
            } else{
                TimerHelper.sleep(1);
            }
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return String.format("\nCashier #%d ", number);
    }
}
