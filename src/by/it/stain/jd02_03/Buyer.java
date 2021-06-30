package by.it.stain.jd02_03;


import java.util.ArrayList;
import java.util.List;


public class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean waitFlag;
    private final MySupermarket mySupermarket;

    public void setWaitFlag(boolean waitFlag) {

        this.waitFlag = waitFlag;
    }

    Object getMonitor() {
        return this;
    }


    public Buyer(long number, MySupermarket mySupermarket) {
        super("Buyer number " + number + " ");
        this.mySupermarket=mySupermarket;
        mySupermarket.getDispatcher().buyerAdd();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        mySupermarket.getDispatcher().buyerComplete();



    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered the supermarket");

    }

    @Override
    public void takeBasket() {
        System.out.println(this + " picked up the basket");
        int waitingTime = RandomTimeForSupermarket.random(500, 2000);
        TimerHelper.sleep(waitingTime);

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " began to select the product");
        int waitingTime = RandomTimeForSupermarket.random(500, 2000);
        TimerHelper.sleep(waitingTime);

        System.out.println(this + " finished selecting the product");

    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            mySupermarket.getQueueBuyers().add(this);
            try {
                waitFlag = true;
                while (waitFlag) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void putGoodsToBasket() {
        int random = RandomTimeForSupermarket.random(1, ShoppingList.getPurchases().size());
        int totalPrice = 0;

        for (int i = 1; i <= random; i++) {
            List<String> purchasesList = new ArrayList<>(ShoppingList.getPurchases().keySet());
            String purchasesName = purchasesList.get(RandomTimeForSupermarket.random(purchasesList.size() - 1));
            int purchasesNameCost = ShoppingList.getPurchases().get(purchasesName);
            totalPrice+=purchasesNameCost;


            int waitingTime = RandomTimeForSupermarket.random(500, 2000);
            TimerHelper.sleep(waitingTime);


            System.out.println(this + " put the product in the basket " + purchasesName + " Cost "+purchasesNameCost);

            if (i != random) {
                chooseGoods();
            }else {
                System.out.println(this+" total amount was " +totalPrice);}


        }
    }


    @Override
    public void goOut() {
        System.out.println(this + " leave out of the supermarket");

    }

    @Override
    public String toString() {
        return this.getName();
    }


}

