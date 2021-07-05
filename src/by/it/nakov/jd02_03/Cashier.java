package by.it.nakov.jd02_03;

public class Cashier implements Runnable {
    private int numberCashier;
    private final Store store;

    public Cashier(int numberCashier, Store store) {
        this.numberCashier = numberCashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(numberCashier + " is open");
//        while (!store.getD storeIsClose()) {
//            AlcoholBuyer alcoholBuyer = QueueBuyers.poll();
//            if (alcoholBuyer != null) {
//                System.out.println(this + " service starts" + alcoholBuyer);
//                int tService = RandomHelper.random(2000, 5000);
//                TimerHelper.sleep(tService);
//                synchronized (alcoholBuyer.getMonitor()) {
//                    alcoholBuyer.setWaitFlag(false);
//                    alcoholBuyer.notify();
//                }
//                System.out.println(this + " finished service " + alcoholBuyer);
//            }
//        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return String.format("\rCashier #%d ", numberCashier);
    }
}
