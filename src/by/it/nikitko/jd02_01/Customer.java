package by.it.nikitko.jd02_01;

import java.util.ArrayList;
import java.util.List;


public class Customer extends Thread implements Customers,UseBacket {

    int customerNumber;

    public Customer(int customerNumber) {
        this.customerNumber = customerNumber;
        this.setName("Customer " + customerNumber);
        start();
    }

    @Override
    public void run() {
        PeoplesCounter.peopleCunt++;
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        PeoplesCounter.peopleCunt--;
    }

    @Override
    public void enterToMarket() {
        System.out.println("Customer " + customerNumber + " enter to the store");
    }

    @Override
    public void chooseGoods() {
        System.out.println("Customer " + customerNumber + " begin choose goods");
        TimeUtils.sleep(RandomUtils.random(500, 2000));
        System.out.println("Customer " + customerNumber + " finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println("Customer " + customerNumber + " go out from the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.printf("Customer #%4d take basket\n",customerNumber);
    }

    @Override
    public void putGoodsToBasket() {

        for (int i = 0; i <  RandomUtils.random(1,4); i++) {

            List<String> goodsList = new ArrayList<>(Goods.goods.keySet());
            String goodsName= goodsList.get(RandomUtils.random(goodsList.size()-1));
            System.out.printf("Customer #%4d put %s in basket\n",customerNumber,goodsName);

        }

    }
}
