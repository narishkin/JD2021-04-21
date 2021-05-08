package by.it.nikitko.jd01_02;


import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        int[][] arr = step1(n);
        int sum = step2(arr);
        System.out.println();
        System.out.println(sum);

        step3(arr);


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
        System.out.println();
        System.out.println();
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

        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        int[] rowsDel = new int[arr.length];                      // хранение индексов рядов на удаление
        int[] columnDel = new int[arr.length];                    // хранение индексов столбцов на удаление
        int countDelRows = 0;                                     // кол-во удаляемых рядов
        int countDelColumns = 0;                                  // кол-во удаляемых столбцов
        int notRepeatRows = -1;                                   //переменная для сравнения при исключении записи повторных индексов рядов
        int notRepeatColumns = -1;                                //переменная для сравнения при исключении записи повторных индексов столбцов
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == max && notRepeatRows != i) {
                    rowsDel[countDelRows] = i;
                    notRepeatRows = i;
                    countDelRows = countDelRows + 1;
                }
                if (arr[i][j] == max && notRepeatColumns != j) {
                    columnDel[countDelColumns] = j;
                    notRepeatColumns = j;
                    countDelColumns = countDelColumns + 1;
                }
            }
        }

        for (int i = countDelRows - 1; i >= 0; i--) {
            arr = removeRow(arr, rowsDel[i]);
        }
        for (int j = 0; j < countDelColumns; j++) {
            //  for (int j = ic - 1; j >= 0; j--) {
            arr = removeColumn(arr, columnDel[j]);
        }

        /*вывод в консоль*/
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {                                       //пропускаем переход на след строку при первом проходе
                System.out.println();
            }
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        return arr;
    }

    /**
     *
     * @param inputArray -
     * @param remRow - row for del
     * @return
     */
    public static int[][] removeRow(int[][] inputArray, int remRow) {
        int[][] finalArr = new int[inputArray.length - 1][inputArray[0].length];

        for (int i = 0; i < finalArr.length; i++) {
            if (i < remRow) {
                finalArr[i] = inputArray[i];
            }
            if (i >= remRow) {
                finalArr[i] = inputArray[i + 1];
            }
        }
        return finalArr;
    }

    /**
     * @param m         - принимаемый массив
     * @param remColumn - column for del
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

        System.out.println();
        System.out.println();
        return finalArr;
    }
}