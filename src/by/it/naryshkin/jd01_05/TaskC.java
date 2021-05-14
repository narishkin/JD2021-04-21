package by.it.naryshkin.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
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

    private static void step2() {
        int[] ArrayA = new int[31];
        for (int i = 0; i < ArrayA.length; i++) {
            ArrayA[i] = (int) (random() * (450 - 102) + 103);
        }
        int counter = 0;
        for (int i = 0; i < ArrayA.length; i++) {
            System.out.print(ArrayA[i] + " ");
            if (ArrayA[i] * 0.1 > i) {
                counter++;
            }
        }
        System.out.println();
        System.out.println("Количество ячеек 10% значения которых больше их индекса в массиве А: " + counter);

        int[] ArrayB = new int[counter];
        int pointerB = 0;
        for (int i = 0; i < ArrayA.length; i++) {
            if (ArrayA[i] * 0.1 > i) {
                ArrayB[pointerB] = ArrayA[i];
                pointerB++;
            }
        }

        Arrays.sort(ArrayB);
        for (int i = 0; i < ArrayB.length; i++) {
            System.out.print(ArrayB[i] + " ");

        }
        System.out.println();
//        {
//            char a = '╬';
//            char b = '╔';
//            char c = '╗';
//            char d = '╝';
//            char e = '╚';
//            char f = '╠';
//            char g = '╣';
//            char h = '╩';
//            char i = '╦';
//            char j = '═';
//            char k = '║';
//        }
        int tableAColumnNumber = 5;
        int elementWidth = 13;
        /*Шапка таблицы А*/
        System.out.print("╔");
        for (int i = 0; i < tableAColumnNumber; i++) {
            if (i != 0) {
                System.out.print("╦");
            }
            for (int j = 0; j <= elementWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.print("╗");
        System.out.println();
        for (int j = 0; j <= 35; j++) {
            System.out.print("║");
            if (j < ArrayA.length) {
                System.out.printf(" %s[%3d] = %d ", "A", j, ArrayA[j]);
            } else {
                System.out.print("              ");
            }
            if ((j + 1) % 5 == 0 && j < 30) {
                System.out.print("║");
                System.out.println();
                System.out.print("╠");
                for (int i = 0; i < tableAColumnNumber; i++) {
                    if (i != 0) {
                        System.out.print("╬");
                    }
                    for (int k = 0; k <= elementWidth; k++) {
                        System.out.print("═");
                    }
                }
                System.out.print("╣\n");
            }
        }
        /*основание таблицы А*/

        System.out.print("\n╚");
        for (int i = 0; i < tableAColumnNumber; i++) {
            if (i != 0) {
                System.out.print("╩");
            }
            for (int j = 0; j <= elementWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.print("╝");
        System.out.println();

        System.out.println();
        int tableBColumnsNumber = 1;
        for (int i = 5; i >= 2; i--) {
            if (ArrayB.length % i == 0) {
                tableBColumnsNumber = i;
                break;
            }
        }
        System.out.println("Number of columns B: " + tableBColumnsNumber);
        int tableBRowsNumber = ArrayB.length / tableBColumnsNumber;
        System.out.println("Number of rows B: " + tableBRowsNumber);


        /*Шапка таблицы B*/
        System.out.print("╔");
        for (int i = 0; i < tableBColumnsNumber; i++) {
            if (i != 0) {
                System.out.print("╦");
            }
            for (int j = 0; j <= elementWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.print("╗");
        System.out.println();

        int pointer = 0;
        for (int i = 0; i < tableBRowsNumber; i++) {
            for (int j = 0; j < tableBColumnsNumber; j++) {
                System.out.print("║");
                System.out.printf(" %s[%3d] =%4d ", "B", pointer, ArrayB[pointer]);
                pointer = pointer + tableBRowsNumber;
            }
            pointer = i + 1;
            System.out.print("║");
            if (i < tableBRowsNumber - 1) {
                System.out.println();
                System.out.print("╠");
                for (int k = 0; k < tableBColumnsNumber; k++) {
                    if (k != 0) {
                        System.out.print("╬");
                    }
                    for (int j = 0; j <= elementWidth; j++) {
                        System.out.print("═");
                    }
                }
                System.out.print("╣\n");
            }

        }
        /*основание таблицы B*/

        System.out.print("\n╚");
        for (int i = 0; i < tableBColumnsNumber; i++) {
            if (i != 0) {
                System.out.print("╩");
            }
            for (int j = 0; j <= elementWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.print("╝");
        System.out.println();
    }


}
