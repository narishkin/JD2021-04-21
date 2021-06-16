package by.it.nikitko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA1 {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }


    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstItem = array[0];
        double lastItem = array[array.length - 1];
        int indexFirstItem = -1;
        int indexLastItem = -1;

        System.out.println("Unsorted array in 5 columns");
        InOut.printArray(array, "V", 5);
        Arrays.sort(array);
        System.out.println("Sorted array in 4 columns");
        InOut.printArray(array, "V", 4);

        for (int i = 0; i < array.length; i++) {
            if (firstItem == array[i]) {
                indexFirstItem = i;
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (lastItem == array[i]) {
                indexLastItem = i;
                break;
            }
        }
        System.out.printf("Index of first element=%-2d%n" +
                "Index of last element=%-2d", indexFirstItem, indexLastItem);

    }
}
