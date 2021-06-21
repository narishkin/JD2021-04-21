package by.it.naryshkin.jd02_02;

public class Dispatcher {

    static volatile int currentCountShoppersInside = 0;
    static volatile int currentCountShoppersAfterExit = 0;

    static boolean storeClosed() {
        return currentCountShoppersAfterExit >= Config.PLAN_SHOPPERS;
    }

    static boolean storeOpened() {
        return currentCountShoppersAfterExit + currentCountShoppersInside < Config.PLAN_SHOPPERS;
    }

    static synchronized void addShopper() {
        currentCountShoppersInside++;
    }

    static synchronized void finishedShoppersCounter() {
        currentCountShoppersInside--;
        currentCountShoppersAfterExit++;

    }


}
