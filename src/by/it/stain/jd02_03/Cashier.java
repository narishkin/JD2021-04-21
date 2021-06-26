package by.it.stain.jd02_03;

public class Cashier implements Runnable {

    private final int number;
    private final MySupermarket mySupermarket;

    public Cashier(int number, MySupermarket mySupermarket){
        this.number=number ;
        this.mySupermarket=mySupermarket;}


    @Override
    public void run() {
        System.out.println(this+" opened");
        while (!mySupermarket.getDispatcher().closedSupermarket()){
            Buyer currentBuyer = mySupermarket.getQueueBuyers().poll();
            if(currentBuyer!= null){
                System.out.println(this+"started service "+ currentBuyer);
                TimerHelper.sleep(RandomTimeForSupermarket.random(2000,5000));
                synchronized (currentBuyer.getMonitor()){
                    currentBuyer.setWaitFlag(false);
                    currentBuyer.notify();
                }
                System.out.println(this+"finished service "+ currentBuyer);
            }
            else{

                TimerHelper.sleep(1);
            }
        }
        System.out.println(this+" closure");


    }

    @Override
    public String toString() {
        return String.format("\rCashier #%d ",number);
    }
}
