package by.it.NakovMaks.jd01_03;

import java.util.Scanner;

import static by.it.NakovMaks.jd01_03.Helper.*;

public class Runner {
    public static void main(String[] args) {

        //A
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray("1 3 4 5 67 7");
        InOut.printArray(array, "V", 4);
        InOut.printArray(array);
        InOut.printArray(array, "v", 3);
        System.out.println("////////////////////");
        //B
        double arr[] = {0.1, 0.2, -0.2, -0.1, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0, 1.0};
        findMin(arr);
        findMax(arr);
        sort(arr);

        //C

    }
}
