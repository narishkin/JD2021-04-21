package by.it.stain.jd02_01;


public class Buyer extends Thread implements IBuyer, IUseBasket {
    static long number;

    public Buyer(long number) {
        super("Buyer number " + number + " ");
        this.number = number;
    }

    @Override
    public void run() {
        Dispatcher.numberOfCustomers++;
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        Dispatcher.numberOfCustomers--;


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
    public void putGoodsToBasket() {
        int random = RandomTimeForSupermarket.random(1, 5);

        for (int i = 1; i <= random; i++) {

            int waitingTime = RandomTimeForSupermarket.random(500, 2000);
            TimerHelper.sleep(waitingTime);


            System.out.println(this + " put the product in the basket " + i);
            if (i != random) {
                chooseGoods();
            }


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

