package by.it.zhurauleu.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner input = new Scanner(System.in);
        buildOneDimArray(input.nextLine());
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d%s%d%s%-2d ", i, "*", j, "=", i * j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        InOut.printArray(array, "v", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int indexOfFirstElement = Arrays.binarySearch(array,firstElement);
        int indexOfLastElement = Arrays.binarySearch(array,lastElement);
        System.out.println("Index of first element=" + indexOfFirstElement);
        System.out.println("Index of last element=" + indexOfLastElement);
    }
}
