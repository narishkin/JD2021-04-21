package by.it.naryshkin.jd01_02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr;
        arr = step1(n);
        step2(arr);
        step3(arr);


    }

    static int[][] step1(int n) {
        int[][] array = new int[n][n];
        Random random = new Random();
        int countpos;
        int countneg;
        do {
            countpos = 0;
            countneg = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = random.nextInt(n * 2 + 1) - n;
//                    array[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
                    if (array[i][j] == n) {
                        countpos += 1;
                    }
                    if (array[i][j] == -n) {
                        countneg += 1;
                    }
                }
            }
        }
        while (countpos == 0 || countneg == 0);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");

            }
            System.out.println();

        }

        return array;

    }

    static int step2(int[][] array) {
        int sum = 0;


        for (int i = 0; i < array.length; i++) {
            int m1 = -1, m2 = -1;

            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 0 && j < (array.length - 1)) {
                    m1 = j;
                    break;
                }

            }
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 0 && j > m1) {
                    m2 = j;
                    break;
                }

            }
            if (m1 >= 0 && m2 >= 0) {
                for (int j = m1 + 1; j < m2; j++) {

                    sum = sum + array[i][j];

                }

            }


        }
        System.out.println("Summ is: " + sum);


        return sum;
    }

    static int[][] step3(int[][] arr) {
        int MAX = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[i][j] + " ");
                if (arr[i][j] > MAX) MAX = arr[i][j];

            }
//            System.out.print('\n');
        }
//        System.out.println(MAX);
        ArrayList<Integer> ilist = new ArrayList<>();
        ArrayList<Integer> jlist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == MAX) {
                    ilist.add(i);
                    jlist.add(j);
                }
            }
        }
//        for (int i = 0; i < ilist.size(); i++) {
//            System.out.println(ilist.get(i) + " " + jlist.get(i));
//        }

        for (int k = 0; k < ilist.size(); k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (j == jlist.get(k) || i == ilist.get(k)) {
                        arr[i][j] = MAX;
                    }
                }
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.print('\n');
//        }

        int sizei = 0;
        int sizej = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != MAX) {
                    sizei = sizei + 1;
                    break;
                }
            }
        }
        for (int j = 0; j < arr.length; j++) {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] != MAX) {

                    sizej = sizej + 1;
                    break;


                }
            }
        }
//        System.out.println(sizei + ":" + sizej);
        // Объявление выходного массива
        int[][] cuttedArray = new int[sizei][sizej];
//        System.out.println("-----------------------------");

//        for (int i = 0; i < cuttedArray.length; i++) {
//            for (int j = 0; j < cuttedArray[i].length; j++) {
//                System.out.print(cuttedArray[i][j] + " ");
//
//
//            }
//            System.out.print('\n');
//        }
        // Заполнение выходного массива ячейками из исходного массива
        int k = 0;
        int l;
        for (int i = 0; i < arr.length; i++) {
            l = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != MAX) {

                    cuttedArray[k][l] = arr[i][j];
                    l += 1;
                }

            }
            if (l > 0) k += 1;

        }
        System.out.println("===============================");
        for (int i = 0; i < cuttedArray.length; i++) {
            for (int j = 0; j < cuttedArray[i].length; j++) {
                System.out.print(cuttedArray[i][j] + " ");


            }
            System.out.print('\n');
        }


        return cuttedArray;

    }


}
