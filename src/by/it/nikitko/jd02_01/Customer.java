package by.it.nikitko.jd02_01;

public class Customer extends Thread implements Customers {

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
        chooseGoods();
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
}
