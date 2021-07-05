package by.it.mogonov.jd02_01;

public class Purchaser extends Thread implements LPurchaser {

    private long number;

    public Purchaser (long number){

        super("Purchaser № " +number+" ");
        this.number=number;
    }

    @Override
    public void run() {
        Manager.currentCountPurchasers++;
        goToKorona();
        chooseGoods();
        goOut();
        Manager.currentCountPurchasers--;
    }

    @Override
    public void goToKorona() {
        System.out.println(this +"filling the Korona");
    }

    @Override
    public void chooseGoods() {

        System.out.println(this +"start");
        int timeout= Randomaser.random(500,2000);
        Timer.sleep(timeout);
        System.out.println(this+"finish");
    }

    @Override
    public void goOut() {
        System.out.println(this+"leave");

    }

    @Override
    public String toString() {
        return this.getName();
    }
}



