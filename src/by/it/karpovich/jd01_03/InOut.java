package by.it.karpovich.jd01_03;

import java.util.Scanner;

public class InOut {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String StringArray = scan.nextLine();
        double[] Array = getArray(StringArray);
    }

    static double[] getArray(String line) {
        String[] StringArray = line.split(" ");
        double[] ResultArray = new double [StringArray.length];
        for (int i = 0; i < StringArray.length; i++) {
            ResultArray[i] = Double.parseDouble(StringArray[i]);
        }
        return ResultArray;
    }

    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
        }
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++){
            System.out.printf("%s[% -3d]=%-10.4f", name, i, arr[i]);
            if ((i+1) % columnCount == 0 || i + 1 == arr.length)
                System.out.println();
        }
    }
}
