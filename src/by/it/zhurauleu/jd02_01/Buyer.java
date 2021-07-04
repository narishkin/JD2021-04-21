package by.it.zhurauleu.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBasket {

    int num;
    final int GOODS_LIMIT = RandomHelper.random(1, 4);
    HashMap<String, Integer> basket = new HashMap<>();


    public Buyer(int num) {
        this.num = num;
        this.setName("buyer №" + num + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "start choose goods");
        int pause = RandomHelper.random(500, 2000);
        TimerHelper.sleep(pause);
        System.out.println(this + "end choose goods");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "left the market");
    }

    @Override
    public void takeBasket() {
        int pause = RandomHelper.random(500, 2000);
        TimerHelper.sleep(pause);
        System.out.println(this + "take basket");
    }

    @Override
    public void putGoodsToBasket() {
        ArrayList<String> goodNameList = new ArrayList<>(Goods.getGoods().keySet());
        int pause = RandomHelper.random(2000, 5000);
        for (int i = 0; i < GOODS_LIMIT; i++) {
            TimerHelper.sleep(pause);
            int goodNameIndex = RandomHelper.random(goodNameList.size() - 1);
            basket.put(goodNameList.get(goodNameIndex), Goods.getGoods().get(goodNameList.get(goodNameIndex)));
            System.out.println(this + "put "+ goodNameList.get(goodNameIndex) +
                    " in the basket with price = " + Goods.getGoods().get(goodNameList.get(goodNameIndex)));
        }
    }
}
