package by.it.nikitko.jd01_02;


import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        int[][] arr = step1(n);
//
//        int sum = step2(arr);
//        System.out.println();
//        System.out.println(sum);

        int[][] arr2 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};

        int[][] ints = step3(arr2);
        System.out.println(Arrays.deepToString(ints));


    }

    static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean flagMin;
        boolean flagMax;
        boolean flagMain = false;
        //Заполняем матрицу
        while (!flagMain) {          //Ожидаем появления n и -n в матрице
            flagMin = false;
            flagMax = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = (int) (Math.random() * 2 * (n + 1) - (n + 1));
                    if (arr[i][j] == -n) {
                        flagMin = true;
                    }
                    if (arr[i][j] == n) {
                        flagMax = true;
                    }
                    if (flagMin && flagMax) {
                        flagMain = true;
                    }
                }
            }
        }

        //Вывод в консоль
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {                        //пропускаем переход на след строку при первом проходе
                System.out.println();
            }
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        return arr;
    }

    static int step2(int[][] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int firstJ = 0;
            int secondJ = 0;
            boolean flagFirstJ = false;
            boolean flagSecondJ = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > 0 && !flagFirstJ) {
                    firstJ = j;
                    flagFirstJ = true;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > 0 && firstJ != j && !flagSecondJ) {
                    secondJ = j;
                    flagSecondJ = true;
                }
            }
            if (secondJ - firstJ > 1) {
                for (int j = firstJ + 1; j < secondJ; j++) {
                    sum = sum + arr[i][j];
                }
            }
        }

        return sum;
    }


    static int[][] step3(int[][] arr) {

        int max = arr.length;
        int[] rowsDel = new int[arr.length];           // хранение рядов на удаление
        int[] columnDel = new int[arr[0].length];         // хранение столбцов на удаление
        int ir = 0;                                    // кол-во удаляемых рядов
        int ic = 0;                                    // кол-во удаляемых столбцов
        int rDt = -1;                                  //переменная для сравнения при исключении записи повторных индексов рядов
        int rDc = -1;                                  //переменная для сравнения при исключении записи повторных индексов столбцов
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == max && rDt != i) {
                    rowsDel[ir] = i;
                    rDt = i;
                    ir = ir + 1;
                    //  System.out.println("ряд " + i);
                }
                if (arr[i][j] == max && rDc != j) {
                    columnDel[ic] = j;
                    rDc = j;
                    ic = ic + 1;
                    //  System.out.println("столбец " + j);
                    //  System.out.println();
                }
            }
        }


        for (int i = ir - 1; i >= 0; i--) {
            arr = removeRow(arr, rowsDel[i]);
        }
        for (int j = 0; j < ic; j++) {
            arr = removeColumn(arr, columnDel[j]);
        }

        /*вывод в консоль*/
        printArray(arr);
        return arr;
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {                                       //пропускаем переход на след строку при первом проходе
                System.out.println();
            }
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static int[][] removeRow(int[][] m, int remRow) {
        int[][] finalArr = new int[m.length - 1][m[0].length];

        for (int i = 0; i < finalArr.length; i++) {
            if (i < remRow) {
                finalArr[i] = m[i];
            }
            if (i >= remRow) {
                finalArr[i] = m[i + 1];
            }
        }
        return finalArr;
    }

    /**
     * @param m         - приимаемый массив
     * @param remColumn - number of deleted column
     * @return
     */
    public static int[][] removeColumn(int[][] m, int remColumn) {
        int[][] finalArr = new int[m.length][m[0].length - 1];
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < finalArr[0].length; ++j) {
                if (j < remColumn) {
                    finalArr[i][j] = m[i][j];
                }
                if (j >= remColumn) {
                    finalArr[i][j] = m[i][j + 1];
                }
            }
        }
        /*вывод в консоль*/
        /*
        for (int i = 0; i < finalArr.length; i++) {
            if (i != 0) {                                       //пропускаем переход на след строку при первом проходе
                System.out.println();
            }
            for (int j = 0; j < finalArr[0].length; j++) {
                System.out.print(finalArr[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println();*/
        return finalArr;
    }
}