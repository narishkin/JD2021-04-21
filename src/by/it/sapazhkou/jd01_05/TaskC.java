package by.it.sapazhkou.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        int quantityElements = 33;
        int i = 0;
        int indexSearch;

        double firstValue = 5.33;
        double lastValue = 9;
        double keySearch = 3.5;
        double compositionElements = 1;
        double step = floor((lastValue - firstValue) / quantityElements * 100) / 100;
        double x = firstValue;
        double[] initialArray = new double[quantityElements];

        while (firstValue <= x && x <= lastValue) {
            initialArray[i] = cbrt((pow(x, 2) + 4.5));
            if (i < initialArray.length - 1) {
                x = floor((x + step) * 100) / 100;
                i++;
            } else {
                break;
            }
        }

        printLineArray(initialArray, 5, "In");

        Arrays.sort(initialArray);

        indexSearch = getIndexSearch(keySearch, initialArray);

        double[] resultArray = new double[initialArray.length - indexSearch];

        System.arraycopy(initialArray, indexSearch, resultArray, 0, resultArray.length);

        for (int j = 0; j < resultArray.length; j++) {
            compositionElements = compositionElements * resultArray[j];
        }
        double result = pow(compositionElements, 1 / resultArray.length);

        printLineArray(resultArray, 5, "Elements > 3.5");

        System.out.println("geometric mean = " + result);
    }


    private static void step2() {

        int initialArraySize = 31;
        int percent = 10;
        int elementFind = 0;

        double firstRandom = 103;
        double lastRandom = 450;

        double[] arrayA = new double[initialArraySize];

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = round(random() * (lastRandom - firstRandom) + firstRandom);
        }
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] * percent / 100 > i) {
                elementFind++;
            }
        }
        int[] indexToCopy = new int[elementFind];
        int j = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] * percent / 100 > i) {
                indexToCopy[j] = i;
                j++;
            }
        }
        double[] arrayB = new double[elementFind];

        for (int i = 0; i < indexToCopy.length; i++) {
            System.arraycopy(arrayA, indexToCopy[i], arrayB, i, 1);
        }

        Arrays.sort(arrayB);

        printArrayWithBorderByString(arrayA, 5, 17, "A");
        printArrayWithBorderByColumn(arrayB, 3, 17, "B");

    }

    private static void printLineBorder(int quantityColumn, int symbolStringToColumn, String type) {
        int lengthString = quantityColumn * symbolStringToColumn;
        int i = 0;
        String str = "";
        int k = 0;
        while (i <= lengthString) {
            if (i == 0 && type == "first") {
                str = str + Character.toString(9556);
            } else if (i == 0 && type == "mid") {
                str = str + Character.toString(9568);
            } else if (i == 0 && type == "last") {
                str = str + Character.toString(9562);
            } else if (k < quantityColumn && i == (k + 1) * symbolStringToColumn && i != lengthString && type == "first") {
                str = str + Character.toString(9574);
                k++;
            } else if (k < quantityColumn && i == (k + 1) * symbolStringToColumn && i != lengthString && type == "mid") {
                str = str + Character.toString(9580);
                k++;
            } else if (k < quantityColumn && i == (k + 1) * symbolStringToColumn && i != lengthString && type == "last") {
                str = str + Character.toString(9577);
                k++;
            } else if (i == lengthString && type == "first") {
                str = str + Character.toString(9559);
            } else if (i == lengthString && type == "mid") {
                str = str + Character.toString(9571);

            } else if (i == lengthString && type == "last") {
                str = str + Character.toString(9565);
            } else {
                str = str + Character.toString(9552);
            }
            i++;
        }
        System.out.println(str);
    }

    private static void printLineArray(double[] array, int quantityColumn, String name) {
        System.out.println("Array " + name);
        int k = 1;
        for (int j = 0; j < array.length; j++) {
            System.out.printf(name + "[% -3d] = %-10.5f", j, array[j]);
            if (k <= (array.length / quantityColumn) && j + 1 == k * quantityColumn) {
                System.out.println();
                k++;
            }
        }
        System.out.println();
    }


    private static void printArrayWithBorderByString(double[] array, int quantityColumn, int symbolStringToColumn, String name) {
        String symbolBorder = Character.toString(9553);
        int quantityString = (int) ceil((double) array.length / (double) quantityColumn);
        System.out.println("Array " + name);
        printLineBorder(quantityColumn, symbolStringToColumn, "first");
        int k = 1;
        for (int j = 0; j < array.length; j++) {
            System.out.printf(symbolBorder + " " + name + "[% -3d] =% -4.1f ", j, array[j]);
            if (k <= (array.length / quantityColumn) && j + 1 == k * quantityColumn) {
                System.out.println(symbolBorder);
                printLineBorder(quantityColumn, symbolStringToColumn, "mid");
                k++;
            }
        }
        System.out.print(symbolBorder);
        if (quantityString * quantityColumn > array.length) {
            for (int i = 0; i < quantityString * quantityColumn - array.length; i++) {
                for (int l = 0; l < symbolStringToColumn - 1; l++) {
                    System.out.print(" ");
                }
                System.out.print(symbolBorder);
            }
        }
        System.out.println();
        printLineBorder(quantityColumn, symbolStringToColumn, "last");
    }

    private static void printArrayWithBorderByColumn(double[] array, int quantityColumn, int symbolStringToColumn, String name) {
        String symbolBorder = Character.toString(9553);
        int quantityString = (int) ceil((double) array.length / (double) quantityColumn);
        System.out.println("Array " + name);
        printLineBorder(quantityColumn, symbolStringToColumn, "first");
        int k = 0;
        for (int i = 0; i < quantityString; i++) {
            for (int j = 0; j < quantityColumn; j++) {
                if ((double) k / (double) array.length <= 1.0 && k+1 <= array.length) {
                    System.out.printf(symbolBorder + " " + name + "[% -3d] =% -4.1f ", k, array[k]);
                    k = k + quantityString;
                } else {
                    System.out.print(symbolBorder);
                    for (int l = 0; l < symbolStringToColumn - 1; l++) {
                        System.out.print(" ");
                    }
                }
            }
            k = i + 1;
            System.out.println(symbolBorder);
            if (i == quantityString - 1) {
                printLineBorder(quantityColumn, symbolStringToColumn, "last");
            } else {
                printLineBorder(quantityColumn, symbolStringToColumn, "mid");
            }
        }

    }


    private static int getIndexSearch(double keySearch, double[] initialArray) {
        int indexSearch;
        int firstIndex = 0;
        int midIndex = -1;
        int lastIndex = initialArray.length - 1;
        while (firstIndex <= lastIndex) {
            midIndex = (lastIndex + firstIndex) / 2;
            if (initialArray[midIndex] > keySearch) {
                lastIndex = midIndex;
            } else {
                firstIndex = midIndex;
            }
            if ((lastIndex - firstIndex) == 1) {
                break;
            }
        }
        indexSearch = lastIndex;
        return indexSearch;
    }


}
