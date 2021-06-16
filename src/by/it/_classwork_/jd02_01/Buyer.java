package by.it._classwork_.jd02_01;

public class Buyer extends Thread implements IBuyer {

    private long number;

    public Buyer(long number) {
        super("Buyer № " + number+" ");
        this.number = number;
    }

    @Override
    public void run() {
        Dispatcher.currentCountBuyers++;
        enterToMarket();
        chooseGoods();
        goOut();
        Dispatcher.currentCountBuyers--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started choose goods");
        int timeout = RandomHelper.random(500, 2000);
        TimerHelper.sleep(timeout);
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaves the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
