package by.it.nikitko.jd01_05;

import by.it.nikitko.jd01_04.InOut;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        step1();


    }

    private static void step1() {

        int lenghtOfArray = getRandomNumber(20, 41);

        double[] array = new double[lenghtOfArray];
        double deltaX = (9 - 5.33) / (lenghtOfArray);
        double x = 5.33;
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.cbrt(x * x + 4.5);
            x = x + deltaX;
        }
        System.out.println("Length of array = " + lenghtOfArray);
        InOut.printArray(array, "A", 5);
        Arrays.sort(array);
        int indexFirstNumber = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                indexFirstNumber = i;
                break;
            }
        }

        System.out.println("New array with numbers more than 3.5");
        double[] arrayB = Arrays.copyOfRange(array, indexFirstNumber, array.length);
        InOut.printArray(arrayB, "B", 5);
        calculateGeometricMeanOfNumbers(arrayB);

    }


    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void calculateGeometricMeanOfNumbers(double[] array) {
        double geometricMeanOfNumbers = 1;
        for (double v : array) {
            geometricMeanOfNumbers = geometricMeanOfNumbers * v;
        }
        geometricMeanOfNumbers = Math.pow(geometricMeanOfNumbers, (1.0 / array.length));
        System.out.printf("Geometric mean of numbers = %4.2f ", geometricMeanOfNumbers);

    }

}
