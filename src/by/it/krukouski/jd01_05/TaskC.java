package by.it.krukouski.jd01_05;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        int quantityElement = (int) ((Math.random() * 21) + 20);
        double[] array = new double[quantityElement];
        int i = 0;
        //заполняем массив
        for (double x = 5.33; x <= 9; x += (9.53 / 5.33) / (quantityElement - 1)) {
            if (i >= quantityElement) {
                break;
            }
            double z = Math.cbrt(x * x + 4.5);
            array[i] = z;
            i++;

        }
        //печатаем массив и считаем количество элементов, которые больше значения 3,5
        int a = 0;
        for (int j = 0; j < array.length; j++) {
            if (j % 5 == 0 && j > 0) {
                System.out.println();
            }
            System.out.printf("%1s[%2d]=%f  ", "v", j, array[j]);
            if (array[j] > 3.5) {
                a++;
            }
        }
        //заполняем итоговый массив с значениями больше 3,5
        double[] resultArray = new double[a];
        int el = 0;
        for (double elementArray : array) {
            if (elementArray > 3.5) {
                resultArray[el] = elementArray;
                el++;
            }

        }
        System.out.println();
        System.out.println();
        //печатаем итоговый массив
        for (int j = 0; j < resultArray.length; j++) {
            if (j % 5 == 0 && j > 0) {
                System.out.println();
            }
            System.out.printf("%1s[%2d]=%f  ", "v", j, resultArray[j]);
        }

        System.out.println();
        //среднее геометрическое значение массива
        double value = 1;
        for (double element : resultArray) {
            value *= element;
        }
        double averageValue = value / resultArray.length;
        System.out.println("Среднее геометрическое значение массива:" + averageValue);
        System.out.println();
    }

    private static void step2() {
        int[] arrayA = new int[31];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) ((Math.random() * 348) + 103);
        }

        int countElementArrayB = 0; //количество элементов, которые войдут в массив В
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] * 0.1 > i) {
                countElementArrayB++;
            }
        }

        int[] arrayB = new int[countElementArrayB];
        int indexArrayB = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] * 0.1 > i) {
                arrayB[indexArrayB] = arrayA[i];
                indexArrayB++;
            }
        }
        Arrays.sort(arrayB);


        //печатаем массив А
        for (int i = 0; i < arrayA.length; i++) {
            if (i % 5 == 0 && i > 0) {
                System.out.println();
            }
            System.out.printf("A[%2d]=%d  ", i, arrayA[i]);
        }
        System.out.println();
        System.out.println();

        //печатаем массив В
        int countsArrayB = 2;
        int rowsArrayB = countElementArrayB/countsArrayB;
        System.out.println("╔===========╦===========╗");
        for (int i = 0; i < rowsArrayB; i++) {
          System.out.printf("║ B[%2d]=%d   B[%2d]=%d ║ \n", i, arrayB[i], i+rowsArrayB, arrayB[i+rowsArrayB]);
        }
        System.out.println("╚=============================================╝");

        /*"╗"
         "╝"
        "╔"
         "╚"
         "╠"
               "╣"
                "╦"
                "╩"
                "╬"
                "═"
               "\\["
                "]"
                "║"
*/


    }
}
