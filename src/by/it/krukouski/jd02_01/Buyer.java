package by.it.krukouski.jd02_01;

public class Buyer extends Thread implements IBuyer{

    private long number;

    public Buyer(long number) {
        super("Buyer № " + number + " ");
        this.number=number;
    }

    @Override
    public void run() {
        CounterBuyers.currentCountBuyers++;
        enterToMarket();
        chooseGoods();
        goOut();
        CounterBuyers.currentCountBuyers--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"Start choose goods");
        int timeout = RandomHelper.random(500,2000);
        TimerHelper.sleep(timeout);
        System.out.println(this+"Finish choose goods");

    }

    @Override
    public void goOut() {
        System.out.println(this + "Go out market");

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
