package by.it.mogonov.jd02_02;

public class Cashier implements Runnable {
    private final int number;

    public Cashier(int number){
        this.number=number;
    }


    @Override
    public void run() {
        System.out.println(this + "open");
        while (!Manager.koronaClosed()){
            Purchaser currentPurchaser= QueuePurchaser.pool();
            if(currentPurchaser !=null){
                System.out.println(this+"start service "+ currentPurchaser);
                int timeService =Randomaser.random(2000,5000);
                Timer.sleep(timeService);
                synchronized (currentPurchaser.getMonitor()){
                    currentPurchaser.setWaitFlag(false);
                    currentPurchaser.notify();
                }
                System.out.println(this+"finish service "+ currentPurchaser);
            }else {
                System.out.println(this + "sleep");
                Timer.sleep(1000);
            }
        }
        System.out.println(this + " close");
    }

    @Override
    public String toString() {
        return String.format("\rCashier #%d ",number);}
    }

