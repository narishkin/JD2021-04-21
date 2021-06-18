package by.it.naryshkin.jd02_01;

public class Dispatcher {
    static  int  currentCountShoppers=0;

    public synchronized void increaseCountShoppers(){
        currentCountShoppers++;
    }

    public synchronized void decreaseCountShoppers(){
        currentCountShoppers--;
    }
}
