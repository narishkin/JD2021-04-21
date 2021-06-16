package by.it.nakov.jd01_02;

import java.util.*;
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
//            step3(arr);
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

    private static int step2(int[][] array) {
        int n = 0;
        int str = 0;
        int firstPositivNum = 0;
        int secondPositivNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[n][i] > 0) str += array[n][i];
        }
        n++;
//        System.out.println("Сумма елементов строки " + n + " равна: "+str);
//        str = 0;
        return str;
    }

}

//    private static int[][] step3(int[][] arr) {
//        if (arr.length == 0) throw new IllegalArgumentException();
//        int max = Integer.MAX_VALUE;
//        List<int[]> deleteMax = new ArrayList(Arrays.asList(max));
//        Collections.shuffle(Collections.singletonList(max));
//        deleteMax.remove(0);
//
//        for (int[] i : arr) {
//            for (int j : i)
//                max = Math.max(max, j);
//        }
//        System.out.println(arr);
//        return arr;
//    }

