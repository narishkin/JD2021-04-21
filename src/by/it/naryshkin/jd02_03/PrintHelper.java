package by.it.naryshkin.jd02_03;

public class PrintHelper {


    public void printConsole(StringBuilder sb, Object o) {

        switch (o.toString()) {
            case "Cashier #0 ": {
                System.out.printf("|%-45s|%-45s|%-45s|%-45s|%-45s|%5d |%5d |\n", sb, "", "", "", "", Shopper.getDequeSize(), Store.storeSum.get());
                break;
            }
            case "Cashier #1 ": {
                System.out.printf("|%-45s|%-45s|%-45s|%-45s|%-45s|%5s |%5d |\n", "", sb, "", "", "", Shopper.getDequeSize(), Store.storeSum.get());
                break;
            }
            case "Cashier #2 ": {

                System.out.printf("|%-45s|%-45s|%-45s|%-45s|%-45s|%5s |%5d |\n", "", "", sb, "", "", Shopper.getDequeSize(), Store.storeSum.get());
                break;
            }
            case "Cashier #3 ": {

                System.out.printf("|%-45s|%-45s|%-45s|%-45s|%-45s|%5s |%5d |\n", "", "", "", sb, "", Shopper.getDequeSize(), Store.storeSum.get());
                break;
            }
            case "Cashier #4 ": {

                System.out.printf("|%-45s|%-45s|%-45s|%-45s|%-45s|%5s |%5d |\n", "", "", "", "", sb, Shopper.getDequeSize(), Store.storeSum.get());
                break;
            }
        }

    }
}
