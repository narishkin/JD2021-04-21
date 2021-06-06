package by.it.krukouski.jd01_13;

import java.util.Scanner;

public class TaskC {
    private static Double[] array = new Double[5];
    private static int err = 0;
    private static int indexArray = 0;


    public static void main(String[] args) throws Exception {
        int i=0;
        while (i<array.length){
            Scanner sc = new Scanner(System.in);
            String number = sc.next();
            readData(number);
            i++;
        }
    }


    private static void readData(String number) throws Exception {
        //Class<Double> type = Double.TYPE;
        try {
            if (err > 5) {
                throw new Exception("Error > 5");
            }
            double value = Double.parseDouble(number);
            array[indexArray] = value;
            indexArray++;

        } catch (NumberFormatException e) {
            e.printStackTrace();
            Thread.sleep(100);
            for (int i = indexArray; i >= 0; i--) {
                System.out.println(array[indexArray] + " ");
            }
            err++;
        }
    }
}

