package by.it.nakov.jd02_02;

public class Cashier implements Runnable {
    private int numberCashier;

    public Cashier(int numberCashier) {
        this.numberCashier = numberCashier;
    }

    @Override
    public void run() {
        System.out.println(numberCashier + " is open");
        while (!Dispatcher.storeIsClose()) {
            AlcoholBuyer alcoholBuyer = QueueBuyers.poll();
            if (alcoholBuyer != null) {
                System.out.println(this + " service starts" + alcoholBuyer);
                int tService = RandomHelper.random(2000, 5000);
                TimerHelper.sleep(tService);
                synchronized (alcoholBuyer.getMonitor()) {
                    alcoholBuyer.setWaitFlag(false);
                    alcoholBuyer.notify();
                }
                System.out.println(this + " finished service " + alcoholBuyer);
            }
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return String.format("\rCashier #%d ", numberCashier);
    }
}
