package by.it.nikitko.jd01_05;

import by.it.nikitko.jd01_04.InOut;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();


    }

    private static void step1() {

        int lenghtOfArray = Helper.getRandomNumber(20, 40);
        double[] array = new double[lenghtOfArray];
        double deltaX = (9 - 5.33) / (lenghtOfArray);
        double x = 5.33;
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.cbrt(x * x + 4.5);
            x = x + deltaX;
        }
        System.out.println("Length of array A = " + lenghtOfArray);
        InOut.printArray(array, "A", 5);
        Arrays.sort(array);
        int indexFirstNumber = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                indexFirstNumber = i;
                break;
            }
        }

        System.out.println("New array B with numbers more than 3.5");
        double[] arrayB = Arrays.copyOfRange(array, indexFirstNumber, array.length);
        InOut.printArray(arrayB, "B", 5);
        Helper.calculateGeometricMeanOfNumbers(arrayB);

    }

    private static void step2() {
        int[] arrayA = new int[31];
        int lenghtArrayB = 0;
        System.out.println();

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = Helper.getRandomNumber(103, 450);
            if (arrayA[i] / 10 > i) {
                lenghtArrayB++;
            }
        }
        Helper.printIntArray(arrayA,"A",5);
        System.out.println();

        int[] arrayB = new int[lenghtArrayB];
        int j=0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] / 10 > i) {
                arrayB[j] = arrayA[i];
                j++;
            }
        }
        Arrays.sort(arrayB);
        Helper.printIntArray(arrayB,"B",5);

    }


}
