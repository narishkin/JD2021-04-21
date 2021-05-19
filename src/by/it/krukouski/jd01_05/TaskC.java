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

        //начало таблицы А
        int columnsA = 5; // количество столбцов в таблице
        int cellWidth = 11; // устанавливаем ширину ячейки
        double rows = (double) arrayA.length / columnsA; //вычисляем количество строк в таблице
        int rowsA = (int) (Math.ceil(rows)); //округляем до целого значения
        System.out.print("╔");
        for (int i = 0; i < columnsA; i++) {
            if (i > 0) {
                System.out.print("╦");
            }
            for (int j = 0; j < cellWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.println("╗");

        //печатаем массив А
        for (int i = 0; i < rowsA * columnsA; i++) {
            if (i < arrayA.length) {
                System.out.printf("║ A[%2d]=%d ", i, arrayA[i]);
            } else {
                System.out.print("║           ");
            }
            if ((i + 1) % columnsA == 0 && i < arrayA.length) {
                System.out.println("║");
                System.out.print("╠");
                for (int k = 0; k < columnsA; k++) {
                    if (k > 0) {
                        System.out.print("╬");
                    }
                    for (int j = 0; j < cellWidth; j++) {
                        System.out.print("═");
                    }
                }
                System.out.println("╣");
            }

        }
        System.out.println("║");

        // конец таблицы А
        System.out.print("╚");
        for (int l = 0; l < columnsA; l++) {
            if (l > 0) {
                System.out.print("╩");
            }
            for (int j = 0; j < cellWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.println("╝");
        System.out.println();
        System.out.println();

        //начало таблицы В
        int columnsB = 2; //устанавливаем количество столбцов в таблице В
        int rowsB = countElementArrayB / columnsB; // вычисляем количество строк таблицы В
        System.out.print("╔");
        for (int i = 0; i < columnsB; i++) {
            if (i > 0) {
                System.out.print("╦");
            }
            for (int j = 0; j < cellWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.println("╗");

        //печатаем массив В
        int indexI = 0;
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < columnsB; j++) {
                System.out.printf("║ B[%2d]=%d ", indexI, arrayB[indexI]);
                indexI+=rowsB;
            }
            indexI=i+1;
            if (i<(rowsB-1)) {
                System.out.println("║");
                System.out.print("╠");
                for (int k = 0; k < columnsB; k++) {
                    if (k > 0) {
                        System.out.print("╬");
                    }
                    for (int j = 0; j < cellWidth; j++) {
                        System.out.print("═");
                    }
                }
                System.out.println("╣");
            }

        }
        System.out.println("║");

        // конец таблицы B
        System.out.print("╚");
        for (int l = 0; l < columnsB; l++) {
            if (l > 0) {
                System.out.print("╩");
            }
            for (int j = 0; j < cellWidth; j++) {
                System.out.print("═");
            }
        }
        System.out.println("╝");

    }
}
