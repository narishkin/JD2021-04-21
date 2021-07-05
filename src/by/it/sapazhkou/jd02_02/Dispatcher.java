package by.it.sapazhkou.jd02_02;

public class Dispatcher {

    static int currentCountBuyer = 0;

    private static volatile int insideCountBuyers = 0;
    private static volatile int completeCountBuyers = 0;

    public static int getInsideCountBuyers() {
        return insideCountBuyers;
    }

    public static int getCompleteCountBuyers() {
        return completeCountBuyers;
    }

    public static boolean marketClosed() {
        return completeCountBuyers == Configs.PLAN_BUYERS;
    }

    static boolean marketOpened() {
        return completeCountBuyers + insideCountBuyers < Configs.PLAN_BUYERS;
    }


    static synchronized void addNewBuyer() {
          insideCountBuyers++;
      }

    static synchronized void completeBuyer() {
        insideCountBuyers--;
        completeCountBuyers++;
    }


}
