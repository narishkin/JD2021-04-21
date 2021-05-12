package by.it.nikitko.jd01_03;

public class Helper {


    static double findMin(double[] arr) {
        if (arr.length == 0) {
            System.out.println("Нулевой массив");
            return Integer.MIN_VALUE;
        } else {
            double arrayMin = arr[0];
            for (double itemOfArr : arr) {
                if (arrayMin > itemOfArr) {
                    arrayMin = itemOfArr;
                }
            }
            System.out.println("Минимум массива = " + arrayMin);
            return arrayMin;
        }
    }


    static double findMax(double[] arr) {
        if (arr.length == 0) {
            System.out.println("Нулевой массив");
            return Integer.MAX_VALUE;
        } else {
            double arrayMax = arr[0];
            for (double itemOfArr : arr) {
                if (arrayMax < itemOfArr) {
                    arrayMax = itemOfArr;
                }
            }
            System.out.println("Максимум массива = " + arrayMax);
            return arrayMax;
        }
    }

    /**
     * Bubble sort
     *
     * @param arr array for sorting
     */
    static void sort(double[] arr) {
        boolean shift;
        int lastIndex = arr.length - 1;
        do {
            shift = false;
            for (int i = 0; i < lastIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    shift = true;
                }
            }
            lastIndex--;
        }
        while (shift);
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }


    static double[] mul(double[][] matrix, double[] vector) {

        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        System.out.println("Результат умножения матрицы на вектор");
        for (double v : result) {
            System.out.println(v);
        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        System.out.println("Результат Умножения матрицы на матрицу");
        for (double[] doubles : result) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(doubles[j] + " ");
                if ((j + 1) % result.length == 0) {
                    System.out.println();
                }
            }
        }
        return result;
    }

}
