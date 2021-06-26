package by.it.naryshkin.jd02_02;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private final int number;
    //    public static int sumCash;
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
        PrintHelper.printConsole(new StringBuilder(this + " opened"), this);
        while (!Dispatcher.storeClosed()) {
            Shopper currentShopper = Shopper.poll();
            if (currentShopper != null) {
                int cashingTime = RandomHelper.random(2000, 5000);
                TimerHelper.sleep(cashingTime);
                synchronized (PrintHelper.class) {
                    synchronized (currentShopper.getMonitor()) {
                        PrintHelper.printConsole(new StringBuilder(this + "started service " + currentShopper), this);
                        currentShopper.setWaitPointer(false);
                        currentShopper.notify();
                        ArrayList<String> list = new ArrayList<>(Store.GOODS.keySet());
                        int totalPrice = 0;
                        for (int i = 0; i < currentShopper.numberOfGoods; i++) {
                            int goodNumber = RandomHelper.random(0, list.size() - 1);
                            StringBuilder sb = new StringBuilder();
                            sb.append(currentShopper.name + " pays for " + list.get(goodNumber) +
                                    " " + Store.GOODS.get(list.get(goodNumber)) + " r.");
                            PrintHelper.printConsole(sb, this);
                            totalPrice += Store.GOODS.get(list.get(goodNumber));
                        }
//                        System.out.println(currentShopper.name + " picked " + currentShopper.numberOfGoods + " goods.");
                        StringBuilder sbTotalPrice = new StringBuilder();
                        sbTotalPrice.append("Total price for " + currentShopper.name + " is " + totalPrice + " r.");
                        PrintHelper.printConsole(sbTotalPrice, this);
                        sumCash = sumCash + totalPrice;
                        Store.storeSum += totalPrice;
                        PrintHelper.printConsole(new StringBuilder(this + "finished service " + currentShopper), this);
                    }
            }
//                System.out.println("Размер очереди: " + Shopper.getDequeSize() + "\n" +
//                        "текущее количество Threads кассиров: " + Store.getCashierThreadsSize());
            } else {
                TimerHelper.sleep(1);
            }
            if (Dispatcher.getCurrentCashiersNumber() > (int) Math.ceil((Shopper.getDequeSize() / (double) 5))) {
                break;
            }
        }
        Dispatcher.removeCashier(Thread.currentThread());
        PrintHelper.printConsole(new StringBuilder(this + " closed"), this);
        synchronized (this) {
            Store.cashiers[number] = false;
            setCashiersMap(this, sumCash);
        }

        PrintHelper.printConsole(new StringBuilder("Итого по кассе в сеансе: " + this + sumCash), this);

    }

    @Override
    public String toString() {
        return String.format("Cashier #%d ", number);
    }
}
