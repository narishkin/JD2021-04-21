package by.it.krukouski.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    private static Double[] array = new Double[]{};
    private static int err = 0;
    private static int indexArray = 0;
    private static String number = "";


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            number = sc.next();
            readData();
        }
    }


    private static void readData() throws InterruptedException {
        try {
            double value = Double.parseDouble(number);
            if (indexArray == array.length) {
                array = Arrays.copyOf(array, (indexArray * 3) / 2 + 1);
            }
            array[indexArray++] = value;
        } catch (NumberFormatException e) {
            err++;
            System.out.println("Error " + err);
            if (err >= 5) {
                throw new InterruptedException("Error >= 5");
            }
            Thread.sleep(100);
            for (int i = indexArray - 1; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}


