package by.it.NakovMaks.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] array = InOut.getArray("1 3 4 5 67 7 ");
        InOut.printArray(array, "V", 4);
        InOut.printArray(array);
//        InOut.printArray(array,"v");
    }
}
