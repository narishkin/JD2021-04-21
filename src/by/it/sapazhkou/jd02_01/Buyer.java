package by.it.sapazhkou.jd02_01;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBasket {


    int num;
    boolean pensioner = false;

    public Buyer(int num) {

        super("Buyer #" + num + " ");
        this.num = num;

    }

    public Buyer(int num, boolean pensioner) {

        super("Buyer #" + num + " ");
        this.num = num;
        this.pensioner = pensioner;

    }


    @Override
    public void run() {
        Dispatcher.currentCountBuyer++;
        enterToMarket();
        chooseGoods();
        goOut();
        Dispatcher.currentCountBuyer--;
        System.out.println("In market " + Dispatcher.currentCountBuyer + " buyers");
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "has entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choosing ");
        int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
        timeChoose = (this.pensioner) ? (int) (timeChoose * 1.5) : timeChoose;
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
        timeChoose = (this.pensioner) ? (int) (timeChoose * 1.5) : timeChoose;
        TimerHelper.sleep(timeChoose);
    }

    @Override
    public void putGoodsToBasket() {
        int countGood = RandomHelper.randomValue(0, 3);
        Basket basket = new Basket(this.num);
        for (int i = 0; i <= countGood; i++) {
            int idGood = RandomHelper.randomValue(0, 3);
            HashMap good = new PriceOfGood().getGoods();
            GoodEnum goodValue = GoodEnum.values()[idGood];
            basket.addToBasket(goodValue);
            int timeChoose = RandomHelper.randomValue(Configs.CHOOSE_MIN, Configs.CHOOSE_MAX);
            timeChoose = (this.pensioner) ? (int) (timeChoose * 1.5) : timeChoose;
            TimerHelper.sleep(timeChoose);
        }
        basket.toConsoleBasket(pensioner);
    }
}
