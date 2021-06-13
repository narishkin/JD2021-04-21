package by.it.marusich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = by.it.marusich.jd01_04.InOut.getArray(line);
        by.it._classwork_.jd01_04.InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int indexFirst = Arrays.binarySearch(array, first);
        int indexLast = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                indexLast = i;
                break;
            }
        }

        System.out.printf("" +
                        "index of first element=%d\n" +
                        "index of last element=%d\n",
                indexFirst, indexLast
        );

    }
}