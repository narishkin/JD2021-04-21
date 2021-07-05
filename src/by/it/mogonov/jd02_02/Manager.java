package by.it.mogonov.jd02_02;

public class Manager {
    private Manager() {
    }


    static int insideCountPurchasers = 0;
    static int completeCountPurchasers = 0;

    static boolean koronaClosed() {
        return completeCountPurchasers == Conctant.PLAN_PURCHASE;

    }
    static boolean koronaOpened(){
        return completeCountPurchasers +insideCountPurchasers<Conctant.PLAN_PURCHASE;
    }
    static synchronized void addNewPurchaser(){

        insideCountPurchasers++;
    }
    static synchronized void complitePurchaser(){
        insideCountPurchasers--;
        completeCountPurchasers++;
    }




}
