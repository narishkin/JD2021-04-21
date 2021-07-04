package by.it.zhurauleu.jd02_02;

public class Buyer extends Thread implements Runnable, IBuyer {


    private boolean waifFlag;

    public void setWaifFlag(boolean waifFlag) {
        this.waifFlag = waifFlag;
    }

    Object getMonitor() {
        return this;
    }

    public Buyer(int num) {
        this.setName("buyer №" + num + " ");
        Dispatcher.addNewBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goToOut();
        Dispatcher.completeBuyer();
    }

    @Override
    public synchronized void goToQueue() {
        QueueBuyers.add(this);
        waifFlag = true;
        while (waifFlag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

}
