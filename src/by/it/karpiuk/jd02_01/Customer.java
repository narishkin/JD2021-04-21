package by.it.karpiuk.jd02_01;

public class Customer extends Thread implements IBuyer {
    private long number;

    public Customer(long number){
        super("Customer № " +number+" ");
        this.number=number;
    }
    @Override
    public void run(){
        Dispatcher.currentCustomers++;
        shopEntry();
        startShopping();
        shopLeave();
        Dispatcher.currentCustomers--;
    }


    @Override
    public void shopEntry() {
        System.out.println(this+"entered the shop");
    }

    @Override
    public void startShopping() {
        System.out.println(this+"started shopping");
        int timeout = RandomHelper.random(500,2000);
        TimerHelper.sleep(timeout);
        System.out.println(this+"finished shopping");

    }

    @Override
    public void shopLeave() {
        System.out.println(this+"leaved the shop ");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}


