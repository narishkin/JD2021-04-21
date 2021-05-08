package by.it.NakovMaks.jd01_02;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TaskC {

    public static void main(String[] args) {

        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        try {
            int n = Integer.parseInt(s);
            int[][] arr = step1(n);
            step2(arr);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("You have entered wrong number!");
            System.out.println("Enter again a number: ");
            main(args);
        }
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];

        int nMax = 0;
        int nMin = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt(-n, n + 1);
                if (nMax == 1 && nMin == 1) {
                    for (int[] k : array) {
                        for (int l : k) {
                            System.out.print(l + " ");
                        }
                        System.out.println();
                    }
                    return array;
                } else if (array[i][j] == -n) nMin = 1;
                else if (array[i][j] == n) nMax = 1;
            }
        }
        if (nMin == 1 && nMax == 1) {
            for (int[] k : array) {
                for (int l : k) {
                    System.out.print(l + " ");
                }
                System.out.println();
            }
            return array;
        } else return step1(n);
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        int indexStart = 0;
        int indexEnd = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1 ; j >= indexStart; j--) {
                if (arr[i][j] > 0) {
                    indexStart = i;
                    indexEnd = j;
                    break;
                }
            }
            System.out.println(arr[indexStart][indexEnd]);
//            System.out.println(sum);
            return sum;
        }


//        static void step3 () {
//
//        }

        return sum;
    }
}