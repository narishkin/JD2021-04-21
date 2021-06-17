package by.it.zhurauleu.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
public class TaskC {

    static final int EXCEPTION_LIMIT = 5;
    static int exceptionCount = 0;
    static Scanner input;

    public static void main(String[] args) throws InterruptedException {
        input = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        List<Double> list = new ArrayList<>();
        for (; ; ) {
            String inputLine = input.nextLine();
            try {
                list.add(Double.parseDouble(inputLine));
            } catch (NumberFormatException e) {
                if (exceptionCount++ == EXCEPTION_LIMIT) {
                    throw new InterruptedException();
                }
                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        }
    }
}






