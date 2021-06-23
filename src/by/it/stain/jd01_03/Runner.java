package by.it.stain.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        double[] array = InOut.getArray(string);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double [][] leftArray = {{1,2},{3,4}};
        double [][] rightArray = {{5,6},{7,8}};
        double [][] result = Helper.mul(leftArray,rightArray);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]+" ");

            }
            System.out.println();

        }





    }
}
