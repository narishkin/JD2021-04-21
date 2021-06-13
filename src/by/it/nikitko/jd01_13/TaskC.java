package by.it.nikitko.jd01_13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class TaskC {

    private static int errorCounter = 0;
    private static final Deque<Double> numbers = new ArrayDeque<>();
    static String currentString;


    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            currentString = scanner.nextLine();
            readData();
        }
    }

    static void readData() throws InterruptedException {
        try {
            String currentString = TaskC.currentString;
            double currentDouble = Double.parseDouble(currentString);
            if (errorCounter < 4) {
                numbers.add(currentDouble);
            }
        } catch (NumberFormatException e) {
            errorCounter++;
            if (errorCounter > 4) {
                throw new InterruptedException();
            }
            Thread.sleep(100);
            Iterator<Double> descendingIterator = numbers.descendingIterator();
            while (descendingIterator.hasNext()) {
                System.out.print(descendingIterator.next() + " ");
            }
            System.out.println();
        }
    }
}
