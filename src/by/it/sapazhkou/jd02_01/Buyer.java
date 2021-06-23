package by.it.sapazhkou.jd02_01;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBasket {


    int num;

    public Buyer(int num) {

        super("Buyer #" + num + " ");
        this.num = num;

    }

    @Override
    public void run() {
        Dispatcher.currentCountBuyer++;
        enterToMarket();
        chooseGoods();
        goOut();
        Dispatcher.currentCountBuyer--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "has entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing ");
        int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
        TimerHelper.sleep(timeChoose);
        putGoodsToBasket();
        System.out.println(this + "completed selection ");

    }

    @Override
    public void goOut() {
        System.out.println(this + "left the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "take a basket ");
        int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
        TimerHelper.sleep(timeChoose);
    }

    @Override
    public void putGoodsToBasket() {
        int countGood = RandomHelper.randomValue(0, 3);
        Basket basket = new Basket(this.num);
        for (int i = 0; i <= countGood; i++) {
            int idGood = RandomHelper.randomValue(0, 3);
            HashMap good = new PriceOfGood().getGoods();
            Good goodValue = Good.values()[idGood];
            basket.addToBasket(goodValue);
            int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
            TimerHelper.sleep(timeChoose);
        }
        System.out.println("Bayer #"+ basket.idBuyer + basket.getBasket().toString());
//        basket.toConsoleBasket();

    }
}
