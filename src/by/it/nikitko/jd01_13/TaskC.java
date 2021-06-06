package by.it.nikitko.jd01_13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class TaskC {

    private static int counter=0;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Deque<Double> inputNumbers = new ArrayDeque<>();

        while (true) {

            String inputString = scanner.nextLine();
            readData(inputString, inputNumbers);

        }
    }

    static void readData(String currentString, Deque numbers) throws Exception {
        try {
            double currentDouble = Double.parseDouble(currentString);
            numbers.add(currentDouble);
        } catch (NumberFormatException e) {
            counter++;
            Thread.sleep(100);
            Iterator<Double> iterRev = numbers.descendingIterator();
            while (iterRev.hasNext()) {

                System.out.print(iterRev.next());
                System.out.print(" ");
            }
            System.out.println();
            if (counter > 4) {
              //  System.out.println("We are here!");
                throw new Exception();
            }
            e.printStackTrace();
        }
    }

}
