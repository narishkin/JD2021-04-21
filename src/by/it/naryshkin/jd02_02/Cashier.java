package by.it.naryshkin.jd02_02;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private final int number;
    public static final Object MONITOR_CASHIER = new Object();

    public Cashier(int number) {
        this.number = number;
    }

    private static synchronized void setCashiersMap(Cashier currentCashier, int sumCash) {
        Store.cashiersMap.put(currentCashier.toString(), Store.cashiersMap.get(currentCashier.toString()) + sumCash);
    }

    @Override
    public void run() {
        int sumCash = 0;
        System.out.println(this + " opened");
        while (!Dispatcher.storeClosed()) {
            Shopper currentShopper = Shopper.poll();
            if (currentShopper != null) {
                int cashingTime = RandomHelper.random(2000, 5000);
                TimerHelper.sleep(cashingTime);
                synchronized (this) {
                    synchronized (currentShopper.getMonitor()) {
                        System.out.println(this + "started cash operation for " + currentShopper);
                        currentShopper.setWaitPointer(false);
                        currentShopper.notify();
                        ArrayList<String> list = new ArrayList<>(Store.GOODS.keySet());
                        int totalPrice = 0;
                        for (int i = 0; i < currentShopper.numberOfGoods; i++) {
                            int goodNumber = RandomHelper.random(0, list.size() - 1);
                            System.out.println(currentShopper.name + " pays " + list.get(goodNumber) +
                                    " by price " + Store.GOODS.get(list.get(goodNumber)));
                            totalPrice += Store.GOODS.get(list.get(goodNumber));
                        }
                        System.out.println(currentShopper.name + " picked " + currentShopper.numberOfGoods + " goods.");
                        System.out.println("--------------------------------------\n" +
                                "Total price for " + currentShopper.name + " is " + totalPrice + " r.\n" +
                                "--------------------------------------\n");
                        sumCash = sumCash + totalPrice;
                    }
                }
                System.out.println(this + "finished service " + currentShopper);
                System.out.println("Размер очереди: " + Shopper.getDequeSize() + "\n" +
                        "текущее количество Threads кассиров: " + Store.getCashierThreadsSize());
            } else {
                TimerHelper.sleep(1);
            }
            if (Dispatcher.getCurrentCashiersNumber() > (int) Math.ceil((Shopper.getDequeSize() / (double) 5))) {
                break;
            }
        }
        System.out.println(this + " closed");
        synchronized (this) {
            setCashiersMap(this, sumCash);
        }

        System.out.println("Итого по кассе в сеансе--------------------------------------------------------------> " + this + sumCash);
        Dispatcher.removeCashier(Thread.currentThread());

    }

    @Override
    public String toString() {
        return String.format("\nCashier #%d ", number);
    }
}
