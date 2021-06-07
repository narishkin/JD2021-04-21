package by.it.krukouski.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    private static Double[] array = new Double[]{};
    private static int err = 0;
    private static int indexArray = 0;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            if (err > 5) {
                throw new Exception("Error > 5");
            }
            String number = sc.next();
            readData(number);
        }
    }


    private static void readData(String number) throws InterruptedException {
        try {
            double value = Double.parseDouble(number);
            if (indexArray == array.length) {
                array = Arrays.copyOf(array, (indexArray * 3) / 2 + 1);
            }
            array[indexArray++] = value;
        } catch (NumberFormatException e) {
            err++;
            Class<? extends NumberFormatException> eClass = e.getClass();
            String name = eClass.getName();
            System.out.println("name Error: " + name);
            Thread.sleep(100);
            for (int i = indexArray - 1; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}

