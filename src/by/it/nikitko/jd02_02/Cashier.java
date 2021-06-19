package by.it.nikitko.jd02_02;

public class Cashier implements Runnable {

    private final int number;

    public Cashier(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return String.format("Cashier # %d ", number);
    }


    @Override
    public void run() {

    }
}
