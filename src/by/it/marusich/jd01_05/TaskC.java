package by.it.marusich.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }


        private static void step1 () {
            int n = (int) (random() * 21 + 20);
            double[] array = new double[n];
            double x1 = 5.33;
            double x2 = 9;
            double x, z;
            double delta = (x2 - x1) / (n - 1);
            System.out.println("Массив A[]");
            int counter = 0;
            for (int i = 0; i < array.length; i++) {
                x = x1 + delta * i;
                z = cbrt(x * x + 4.5);
                array[i] = z;
                if (array[i] > 3.5) {
                    counter++;
                }
                if (i % 5 == 0 && i > 0) {
                    System.out.println();
                }
                System.out.printf("A[%3d] = %6.5f   ", i, z);
            }
            double[] arrayFiltered = new double[counter];
            System.out.println("\n" + counter);
            int indexAF = 0;
            double AFmult = 1;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 3.5) {
                    arrayFiltered[indexAF] = array[i];
                    AFmult = AFmult * arrayFiltered[indexAF];
                    indexAF++;
                }
            }
            System.out.println("Массив B[]");
            for (int i = 0; i < arrayFiltered.length; i++) {
                if (i % 5 == 0 && i > 0) {
                    System.out.println();
                }
                System.out.printf("B[%3d] = %6.5f   ", i, arrayFiltered[i]);
            }
            System.out.println();
            System.out.println("Произведение элементов массива: " + AFmult);
            double GeometricalMean = pow(AFmult, ((double) 1 / arrayFiltered.length));
            System.out.println("Среднее геометрическое значение массива: " + GeometricalMean);
        }
    }
