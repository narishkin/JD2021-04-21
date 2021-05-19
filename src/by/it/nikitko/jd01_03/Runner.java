package by.it.nikitko.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] array = InOut.getArray(scanner.nextLine());
        InOut.printArray(array);
        InOut.printArray(array, "Example", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

        double[][] exampleMatrixLeft = {{2, 5, 5, 7}, {5, 7, 2, 9}};
        double[][] exampleMatrixRight = {{1, 2, 8, 7}, {-2, 4, -1, 0}};
        double[] exampleVector = {0, 5, 4, -2};

        Helper.mul(exampleMatrixLeft,exampleVector);
        Helper.mul(exampleMatrixLeft,exampleMatrixRight);

    }
}
