package by.it.nakov.jd02_03;

//public class AlcoholBuyer extends Thread implements IAlcoholBuyer {
//    private int numberInTheQueue;
//
//    Object getMonitor(){return this;}
//
//    public AlcoholBuyer(int numberInTheQueue) {
//        super("Buyer number: " + numberInTheQueue);
//        this.numberInTheQueue = numberInTheQueue;
//    }
//
//    public static AlcoholBuyer pollFirst() {
//        return null;
//    }
//
//    public static void addLast(AlcoholBuyer alcoholBuyer) {
//    }
//
//
//    public void run() {
//        Dispatcher.currentCountBuyers++;
//        enteredToTheStore();
//        takeBasket();
//        chooseTheAlcohol();
//        putGoodsToBasket();
//        goOut();
//        Dispatcher.currentCountBuyers--;
//    }
//
//
//    @Override
//    public void enteredToTheStore() {
//        System.out.println(this.numberInTheQueue + " entered into the store.");
//    }
//
//    @Override
//    public void takeBasket() {
//        System.out.println(this.numberInTheQueue + " take a basket");
//        TimerHelper.sleep(RandomHelper.random(500, 2000));
//    }
//
//    @Override
//    public void chooseTheAlcohol() {
//        System.out.println(this.numberInTheQueue + " started choose alcohol.");
//        int timeOut = RandomHelper.random(500, 2000);
//        TimerHelper.sleep(timeOut);
//        System.out.println(numberInTheQueue + " finished choose alcohol.");
//    }
//
//    @Override
//    public void putGoodsToBasket() {
//
//    }
//
//    @Override
//    public void goOut() {
//
//        System.out.println(this.numberInTheQueue + " left the store.");
//
//    }
//
//    public boolean waitFlag;
//
//    public void setWaitFlag(boolean waitFlag) {
//        this.waitFlag = waitFlag;
//    }
//}
