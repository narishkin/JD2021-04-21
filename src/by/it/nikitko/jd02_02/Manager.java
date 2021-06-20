package by.it.nikitko.jd02_02;

public class Manager {

    static  int peopleCount =0;
    static  int peopleInStore=0;


    private static volatile int customersInsideCount = 0;
    private static volatile int servedCustomersCount = 0;


    static boolean storeClosed() {
        return servedCustomersCount == Config.CUSTOMER_PLAN;
    }

    static boolean storeOpened() {
        return servedCustomersCount + customersInsideCount < Config.CUSTOMER_PLAN;
    }

    static synchronized void addCustomer(){
        customersInsideCount++;
    }

    static synchronized void servedCustomer(){
        customersInsideCount--;
        servedCustomersCount++;
    }

}
