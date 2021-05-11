package by.it.zhurauleu.jd01_05;


import by.it.zhurauleu.jd01_04.InOut;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    static void step1() {
        int n = getMassiveLength();
        double[] arrayZ = new double[n];
        fillMassiveZ(n, arrayZ);
        double[] arrayB = new double[getNewArrayLength(arrayZ)];
        fillArrayB(arrayZ, arrayB);
        InOut.printArray(arrayZ, "z", 7);
        InOut.printArray(arrayB, "arrayB", 7);
        System.out.println(calculateGeometricMean(arrayB));
    }

    private static void fillArrayB(double[] arrayZ, double[] arrayB) {
        for (int i = arrayZ.length - arrayB.length, j = 0; i < arrayZ.length; i++) {
            arrayB[j] = arrayZ[i];
            j++;
        }
    }

    private static int getNewArrayLength(double[] arrayZ) {
        int newArrayLength = 0;
        boolean findNewArrayLength = false;
        int i = 0;
        do {
            if (arrayZ[i] > 3.5 && !findNewArrayLength) {
                newArrayLength = arrayZ.length - i;
                findNewArrayLength = true;
            }
            i++;
        } while (findNewArrayLength && i < arrayZ.length);
        System.out.println("newArrayLength = " + newArrayLength);
        return newArrayLength;
    }

    private static void fillMassiveZ(int n, double[] array) {
        int index = 0;
        double z;
        for (double x = 5.33; x <= 9.01; x += (9 - 5.33) / (n - 1)) {
            z = cbrt(x * x + 4.5);
            array[index] = z;
            index++;
        }
    }

    private static int getMassiveLength() {
        int n = (int) (Math.random() * 21) + 20;
        System.out.println("n = " + n);
        return n;
    }

    static double calculateGeometricMean(double[] array) {
        double multiplication = array[0];
        for (int i = 1; i < array.length; i++) {
            multiplication *= array[i];
        }
        return exp(log(multiplication) / array.length);
    }
}
