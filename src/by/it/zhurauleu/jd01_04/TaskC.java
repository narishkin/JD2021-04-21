package by.it.zhurauleu.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("9 8 7 6");
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
//        InOut.printArray(array, "v", 90);
        mergeSort(array);
//        InOut.printArray(array, "V", 4);
//        int indexOfFirstElement = Arrays.binarySearch(array,firstElement);
//        int indexOfLastElement = Arrays.binarySearch(array,lastElement);
//        System.out.println("Index of first element=" + indexOfFirstElement);
//        System.out.println("Index of last element=" + indexOfLastElement);
    }

    private static void mergeSort(double[] array) {
//        System.out.print("делим: ");
        InOut.printArray(array, "v", 90);
        if (array.length > 1) {
            int middleIndex = array.length / 2;
            int leftCorner = 0;
            int rightCorner = array.length - 1;
//            System.out.println("middleIndex = " + middleIndex);
//            System.out.println("right index = " + rightCorner);
//            System.out.println("left index = " + leftCorner);
            double[] leftPart = new double[middleIndex - leftCorner];
            double[] rightPart = new double[rightCorner - middleIndex + 1];
//            System.out.println("leftPartLength = " + leftPart.length);
//            System.out.println("rightPartLength = " + rightPart.length);
            System.out.println();
            System.arraycopy(array, 0, leftPart, 0, leftPart.length);
            System.arraycopy(array, middleIndex, rightPart, 0, rightPart.length);
            mergeSort(leftPart);
            mergeSort(rightPart);
            double[] resultArray = merge(leftPart, rightPart);
        }
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] resultArray = new double[part1.length + part2.length];
        int pos1 = 0;
        int pos2 = 0;
        for (int i = 0; i < resultArray.length; i++) {

            if (pos1 == part1.length) {
                resultArray[i] = part2[pos2];
            } else if (pos2 == part2.length) {
                resultArray[i] = part1[pos1];
            } else if (part1[pos1] < part2[pos2]) {
                resultArray[i] = part1[pos1];
                pos1++;
            } else {
                resultArray[i] = part2[pos2];
                pos2++;
            }
        }
        System.out.println("merged array:");
        InOut.printArray(resultArray, "v", 90);
        return resultArray;
    }

}
