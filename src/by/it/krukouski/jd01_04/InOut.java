package by.it.krukouski.jd01_04;


public class InOut {
    /**
     * Данный метод преобразовывает строку в массив из чисел с плавающей точкой и возвращает его
     *
     * @param line массив в виде строки
     * @return возвращает массив из чисел с плавающей точкой
     * @count количество элементов в строковом массиве
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] elemString = line.split(" ");
        int count = elemString.length;
        double[] array = new double[count];
        for (int i = 0; i < count; i++) {
            array[i] = Double.parseDouble(elemString[i]);
        }
        return array;
    }

    /**
     * Этот метод печает массив из чисел с плавающей точкой
     *
     * @param array массив из чисел с плавающей точкой
     *              elementArray каждый член массива array
     */

    static void printArray(double[] array) {
        for (double elementArray : array) {
            System.out.print(elementArray + " ");
        }
    }

    /**
     * Этот метод печатает массив из чисел с плавающей точкой с помощью форматирования
     *
     * @param array          массив из чисел с плавающей точкой
     * @param name           имя столбца
     * @param columnQuantity количество столбцов
     *                       column счётчик столбцов
     */

    static void printArray(double[] array, String name, int columnQuantity) {
        int column = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%1s[%1d]=%-5.2f ", name, i, array[i]);
            column++;
            if (column % columnQuantity == 0) {
                System.out.println();
            }

        }
    }
}

