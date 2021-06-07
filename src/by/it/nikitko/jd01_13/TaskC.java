package by.it.nikitko.jd01_13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class TaskC {

    private static int errorCounter =0;
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
            if (errorCounter <4) {
                numbers.add(currentDouble);
            }
        } catch (NumberFormatException e) {
            errorCounter++;
            if (errorCounter >4) {
                throw new Exception();
            }
            Thread.sleep(100);
            Iterator<Double> iterRev = numbers.descendingIterator();
            while (iterRev.hasNext()) {
                System.out.print(iterRev.next()+" ");
            }
            System.out.println();
          //  e.printStackTrace();
        }
    }

}
/*
1
2
err1
3
4
err2
err3
err4
err5
5.0
err6
*/