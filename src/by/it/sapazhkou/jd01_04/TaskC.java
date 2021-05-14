package by.it.sapazhkou.jd01_04;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] resultArray = InOut.getArray(line);
        double firstElement = resultArray[0];
        double lastElement = resultArray[resultArray.length - 1];
        InOut.printArray(resultArray, "V", 5);
        mergeSort(resultArray);
        InOut.printArray(resultArray, "V", 4);
        System.out.printf("" +
                "Index of first element=%1d" + "%n" +
                "Index of last element=%1d", binarySearch(resultArray,firstElement), binarySearch(resultArray,lastElement));
        System.out.println();
    }

    static void mergeSort(double[] array) {

        double[] arrayMerge = mergeSort(array, 0, array.length - 1);
        System.arraycopy(arrayMerge, 0, array, 0, array.length);

    }

    private static double[] mergeSort(double[] array, int left, int right) {

        if (array == null) {
            return array;
        }
        if (array.length < 2) {
            return array;
        }
        double[] arrayLeft = new double[array.length / 2];
        System.arraycopy(array, left, arrayLeft, left, array.length / 2);

        double[] arrayRight = new double[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayRight, 0, array.length - array.length / 2);
        arrayLeft = mergeSort(arrayLeft, 0, arrayLeft.length - 1);
        arrayRight = mergeSort(arrayRight, 0, arrayRight.length - 1);

        return merge(arrayLeft, arrayRight);

    }

    private static double[] merge(double[] part1, double[] part2) {

        double[] partMerge = new double[part1.length + part2.length];
        int position1 = 0;
        int position2 = 0;
        int i = 0;

        while (i < partMerge.length) {
            partMerge[i] = part1[position1] < part2[position2] ? part1[position1++] : part2[position2++];
            if (position1 == part1.length) {
                System.arraycopy(part2, position2, partMerge, ++i, part2.length - position2);
                break;
            }
            if (position2 == part2.length) {
                System.arraycopy(part1, position1, partMerge, ++i, part1.length - position1);
                break;
            }
            i++;
        }
        return partMerge;
    }

    static int binarySearch(double[] array, double value) {

        int firstIndex = 0;
        int lastIndex = array.length - 1;


        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;
            if(array[middleIndex] == value){
                return middleIndex;
            } else if(array[middleIndex] < value){
                firstIndex = middleIndex + 1;
            } else if(array[middleIndex] > value){
                lastIndex = middleIndex - 1;
            }

        }
        return -1;
    }

}
