package by.it.sapazhkou.jd02_01;

public class Buyer extends Thread implements IBuyer {


    int num;

    public Buyer(int num) {

        super("Buyer #" + num + " ");
        this.num = num;

    }

    @Override
    public void run() {
//        Dispatcher.currentCountBuyer++;
        enterToMarket();
        chooseGoods();
        goOut();
//        Dispatcher.currentCountBuyer--;
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
}
