package by.it.zhurauleu.jd02_03;

public class Cashier extends Thread implements Runnable {

    private final int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Cashier №%d ", number);
    }

    @Override
    public void run() {
        System.out.println(this + "open");
        while (!Dispatcher.marketClosed()) {
            Buyer currentBuyer = QueueBuyers.poll();
            if (currentBuyer != null) {
                System.out.println(this + "start service " + currentBuyer);
                int timeService = RandomHelper.random(2000, 5000);
                TimerHelper.sleep(timeService);
                synchronized (currentBuyer.getMonitor()) {
                    currentBuyer.setWaifFlag(false);
                    currentBuyer.notify();
                }
                System.out.println(this + "end service " + currentBuyer);
                printCheck(currentBuyer);
            }
        }
        System.out.println(this + "closed");
    }

    private void printCheck(Buyer currentBuyer) {
        System.out.printf("%s check:", currentBuyer);
        for (String good : currentBuyer.getBASKET()) {
            System.out.printf(" %s = %d", good, Goods.getGoods().get(good));
        }
        System.out.println(", sum = " + currentBuyer.getCheckSum());
    }
}
