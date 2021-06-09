package by.it.naryshkin.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static Scanner sc;

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        List<Double> list = new ArrayList<>();
        String s;
        int counter = 0;
        while (true) {
            s = sc.next();
            System.out.println(s);
            try {
                list.add(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                counter++;

                if (counter == 5) {
                    throw new InterruptedException();
                }
                Thread.sleep(100);
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(list.size() - 1 - i) + " ");
                }
                System.out.println();
            }

        }

    }
}
