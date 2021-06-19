package by.it.krukouski.jd02_01;

import java.util.ArrayList;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private long number;

    public Buyer(long number) {
        super("Buyer № " + number + " ");
        this.number = number;
    }

    @Override
    public void run() {
        CounterBuyers.currentCountBuyers++;
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        CounterBuyers.currentCountBuyers--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Start choose goods");
        int timeout = RandomHelper.random(500, 2000);
        TimerHelper.sleep(timeout);
        System.out.println(this + "Finish choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "Go out market");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Take Basket");
    }

    @Override
    public void putGoodsToBasket() {
        int countGoods = RandomHelper.random(1, 4);
        int timeout = RandomHelper.random(500, 2000);
        for (int i = 0; i < countGoods; i++) {
            ArrayList<String> strings = new ArrayList<>(HashMapGoods.getHashMap().keySet());
            String good = strings.get(RandomHelper.random(strings.size()-1));
            TimerHelper.sleep(timeout);
            System.out.println(this + "put " + good + " to basket");

        }
    }
}
