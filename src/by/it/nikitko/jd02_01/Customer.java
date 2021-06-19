package by.it.nikitko.jd02_01;

import java.util.ArrayList;
import java.util.List;


public class Customer extends Thread implements Customers, UseBasket {

    int customerNumber;
    boolean pensioner;

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public Customer(int customerNumber) {
        this.customerNumber = customerNumber;
        this.setName("Customer " + customerNumber);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {

        System.out.printf("Customer #%4d enter to the store \n", customerNumber);
        PeoplesCounter.peopleInStore++;
        // System.out.println("peopleInStore " + PeoplesCounter.peopleInStore);
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
        PeoplesCounter.peopleInStore--;
        //  System.out.println("peopleInStore " + PeoplesCounter.peopleInStore);
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
            if (pensioner) {
                TimeUtils.sleep(RandomUtils.random(500, 3000));
            } else {
                TimeUtils.sleep(RandomUtils.random(500, 2000));
            }
            System.out.printf("Customer #%4d put %s with price %d in basket\n", customerNumber, goodsName, Goods.getGoods().get(goodsName));

        }

    }
}
