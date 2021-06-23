package by.it.nikitko.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Customer extends Thread implements Customers, UseBasket {

    private final int customerNumber;

    public boolean isPensioner() {
        return pensioner;
    }

    private boolean pensioner;
    private boolean flagWait;
    private final HashMap<String, Integer> customerGoods = new HashMap<>();


    public HashMap<String, Integer> getCustomerGoods() {
        return customerGoods;
    }

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }


    public Customer(int customerNumber) {
        this.customerNumber = customerNumber;
        this.setName("Customer " + customerNumber);
    }

    Object getMonitor() {
        return this;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            System.out.printf("Customer #%4d go to the queue \n", customerNumber);
            if (this.pensioner) {
                QueueCustomers.addPensioner(this);
            } else {
                QueueCustomers.add(this);
            }
            wakeUpCashier();
            try {
                flagWait = true;
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void wakeUpCashier() {
        synchronized (this) {
            int cashierNeeded = (int) Math.ceil(QueueCustomers.getSize() / Config.MAX_QUEUE_LENGTH);
            int openedCashier = ClosedCashiers.getOpenedCashier();
            System.out.println("Queue size: " + QueueCustomers.getSize());
            System.out.println("cashierNeeded: " + cashierNeeded);
            System.out.println("cashierOpened: " + openedCashier);
            while (ClosedCashiers.getSize() > 0 & openedCashier < cashierNeeded) {
                Cashier currentCashier = ClosedCashiers.poll();
                synchronized (currentCashier.getMonitor()) {
                    openedCashier = ClosedCashiers.getOpenedCashier();
                    currentCashier.setFlagWait(false);
                    currentCashier.notify();
                }
            }
        }
    }

    @Override
    public void enterToMarket() {

        System.out.printf("Customer #%4d enter to the store \n", customerNumber);
        Manager.peopleInStore++;
        Manager.addCustomer();
    }

    @Override
    public void chooseGoods() {
        System.out.printf("Customer #%4d begin choose goods \n", customerNumber);
        if (pensioner) {
            TimeUtils.sleep(RandomUtils.random(500, 3000));
        } else {
            TimeUtils.sleep(RandomUtils.random(500, 2000));
        }
        System.out.printf("Customer #%4d finished choose goods \n", customerNumber);
    }

    @Override
    public void goOut() {
        System.out.printf("Customer #%4d go out from the store \n", customerNumber);
        Manager.peopleInStore--;
        Manager.servedCustomer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.printf("Customer #%4d take basket\n", customerNumber);
        if (pensioner) {
            TimeUtils.sleep(RandomUtils.random(500, 3000));
        } else {
            TimeUtils.sleep(RandomUtils.random(500, 2000));
        }
    }

    @Override
    public void putGoodsToBasket() {

        for (int i = 0; i < RandomUtils.random(1, Goods.getGoods().size()); i++) {
            List<String> goodsList = new ArrayList<>(Goods.getGoods().keySet());
            String goodsName = goodsList.get(RandomUtils.random(goodsList.size() - 1));

            int count = customerGoods.getOrDefault(goodsName, 0);
            customerGoods.put(goodsName, count + 1);


            if (pensioner) {
                TimeUtils.sleep(RandomUtils.random(500, 3000));
            } else {
                TimeUtils.sleep(RandomUtils.random(500, 2000));
            }
            System.out.printf("Customer #%4d put %s with price %d in basket\n", customerNumber, goodsName, Goods.getGoods().get(goodsName));
        }
    }
}
