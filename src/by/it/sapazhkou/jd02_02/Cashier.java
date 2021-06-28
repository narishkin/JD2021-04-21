package by.it.sapazhkou.jd02_02;

public class Cashier implements Runnable{

    private final int idCashier;

    public Cashier(int idCashier) {
        this.idCashier = idCashier;
    }

    @Override
    public void run() {

        System.out.println(this + " opened");
        while (!Dispatcher.marketClosed()) {
            Buyer currentBuyer = QueueBuyers.poll();
            if (currentBuyer != null) {
                System.out.println(this + "started service " + currentBuyer);
                int timeService = RandomHelper.randomValue(2000, 5000);
                TimerHelper.sleep(timeService);
                synchronized (currentBuyer.getMonitor()) {
                    currentBuyer.setWaitFlag(false);
                    currentBuyer.notify();
                    Dispatcher.completeBuyer();
                }
                System.out.println(this + "finished service " + currentBuyer);
            } else {
                //тут надо подумать что дальше будет делать кассир
                TimerHelper.sleep(1);
            }
        }
        System.out.println(this + " closed");
    }


    @Override
    public String toString() {
        return String.format("\rCashier #%d ", idCashier);
    }
}
