package by.it.karpovich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    private static double[] mergeSortReal(double[] resultArray, int lo, int hi) {
        if (hi <= lo)
            return resultArray;
        int mid = lo + (hi - lo) / 2;
        mergeSortReal(resultArray, lo, mid);
        mergeSortReal(resultArray, lo, mid);

        double[] buf = Arrays.copyOf(resultArray, resultArray.length);

        for (int k = lo; k <= hi; k++)
            buf[k] = resultArray[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                resultArray[k] = buf[j];
                j++;
            } else if (j > hi) {
                resultArray[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                resultArray[k] = buf[j];
                j++;
            } else {
                resultArray[k] = buf[i];
                i++;
            }
        }
        return resultArray;
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

  static double[] mergeSort(double[] resultArray) {
        resultArray = mergeSortReal(resultArray, 0, resultArray.length -1);
        return resultArray;
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
