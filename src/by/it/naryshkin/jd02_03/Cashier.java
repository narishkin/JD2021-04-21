package by.it.naryshkin.jd02_03;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private final int number;
    private final Dispatcher dispatcher;

    public Cashier(int number, Dispatcher dispatcher) {
        this.number = number;
        this.dispatcher = dispatcher;
    }

    private static void setCashiersMap(Cashier currentCashier, int sumCash) {
        Store.cashiersMap.put(currentCashier.toString(), Store.cashiersMap.get(currentCashier.toString()) + sumCash);
    }

    @Override
    public void run() {
        PrintHelper printHelper = new PrintHelper();
        int sumCash = 0;
        printHelper.printConsole(new StringBuilder(this + " opened"), this);
        while (dispatcher.storeOpened()) {
            Shopper currentShopper = Shopper.poll();
            if (currentShopper != null) {
                int cashingTime = RandomHelper.random(2000, 5000);
                TimerHelper.sleep(cashingTime);
                synchronized (PrintHelper.class) {
                    synchronized (currentShopper.getMonitor()) {
                        printHelper.printConsole(new StringBuilder(this + "started service " + currentShopper), this);
                        currentShopper.setWaitPointer(false);
                        currentShopper.notify();
                        ArrayList<String> list = new ArrayList<>(Store.GOODS.keySet());
                        int totalPrice = 0;
                        for (int i = 0; i < currentShopper.numberOfGoods; i++) {
                            int goodNumber = RandomHelper.random(0, list.size() - 1);
                            StringBuilder sb = new StringBuilder();
                            sb.append(currentShopper.name + " pays for " + list.get(goodNumber) +
                                    " " + Store.GOODS.get(list.get(goodNumber)) + " r.");
                            printHelper.printConsole(sb, this);
                            totalPrice += Store.GOODS.get(list.get(goodNumber));
                        }
//                        System.out.println(currentShopper.name + " picked " + currentShopper.numberOfGoods + " goods.");
                        StringBuilder sbTotalPrice = new StringBuilder();
                        sbTotalPrice.append("Total price for " + currentShopper.name + " is " + totalPrice + " r.");
                        printHelper.printConsole(sbTotalPrice, this);
                        sumCash = sumCash + totalPrice;
                        Store.storeSum.getAndAdd(totalPrice);
                        printHelper.printConsole(new StringBuilder(this + "finished service " + currentShopper), this);
                    }
                }
            } else {
                TimerHelper.sleep(1);
            }
            if (dispatcher.getCurrentCashiersNumber() > (int) Math.floor((Shopper.getDequeSize() / (double) 5) + 1)) {
                break;

            }
        }
        Store.cashiers.set(number, false);
        printHelper.printConsole(new StringBuilder(this + " closed"), this);
        dispatcher.removeCashier();

        setCashiersMap(this, sumCash);

        printHelper.printConsole(new StringBuilder("Итого по кассе в сеансе: " + this + sumCash), this);

    }

    @Override
    public String toString() {
        return String.format("Cashier #%d ", number);
    }
}
