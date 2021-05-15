/*В классе TaskC (пакет by.it.familiya.jd01_02) один раз введите с консоли n
через объект типа Scanner - размерность матрицы arr [n] [n] и вызовите из
метода main статические методы step1 step2 step3 с указанной сигнатурой:
1. Задать значения элементов матрицы в интервале значений от -n до n с
помощью генератора случайных чисел. Числа целые. Тип int.
Пока в матрице нет чисел n и -n генерацию следует повторять, иначе
вывести матрицу в консоль, а затем, вернуть полученную матрицу.
Сигнатура int[ ][ ] step1(int n).
2. Найти, вывести и вернуть сумму элементов исходной матрицы arr,
расположенных между первым и вторым положительными элементами
каждой строки. Сигнатура int step2(int[ ][ ] arr).
3. Найти максимальный элемент(ы) в матрице и удалить из исходной
матрицы все строки и столбцы, его содержащие. Вывести в консоль и
вернуть полученную матрицу. Сигнатура int[ ][ ] step3(int[ ][ ] arr).
При выводе результатов в консоль отделяйте элементы строк одиночными
пробелами, а сами строки - переносами \n */
package by.it.stain.jd01_02;


import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число: ");
        int n = s.nextInt();



        step1(n);
          // step2(n);
        // step3();

    }

    private static  int[][]  step1( int n) {
        int[][] array = new int[n][n];


        // int min=array[0][0];
        // int max=array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                array[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }


        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();

        }
        return array;
    }

      /*  for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j]<min){
                    min=array[i][j];
                }

            }

            
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j]>max){
                    max=array[i][j];
                }
            }
        }
        System.out.println("min = "+min);
        System.out.println("max = "+max);
        // }*/


   /* private static int[][] step2( int n) {
       /* int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                array[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }
        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();

        }


        int sum = 0;


        for (int i = 0; i < array.length; i++) {
            int x = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 0) {
                    x++;
                    if (x == 1) {
                        if (array[i][j+1]  > 0) {
                            System.out.println("Не достаточно положительных элементов в " + (i + 1) + " строке");
                        } else if (array[i][j+2]  > 0) {
                            System.out.println("Не достаточно положительных элементов в " + (i + 1) + " строке");
                        } else {

                            for (int b=j+1; 0 <= array[i][b]; b++) {
                                sum += array[i][b];
                            }
                            System.out.println("Сумма элементов в "+(i+1)+" строке = "+sum);
                        }


                    }else if(x ==0 ){
                        System.out.println("В строке "+(i+1)+" нет положительных элементов");
                    }
                }


            }

        }
        return array;*/


        //private static void step3() {
    }


