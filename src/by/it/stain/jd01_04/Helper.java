package by.it.stain.jd01_04;

public class Helper {
    public static void main(String[] args) {


    }

    static double findMin(double[] array) {
        double min = array[0];
        for (double m : array) {
            if (min > m) {
                min = m;
            }

        }
        System.out.println(min + " минимальный элемент");
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (double m : array) {
            if (max < m) {
                max = m;
            }

        }
        System.out.println(max + " максимальный элемент");
        return max;
    }

    static void sort(double[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;


                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];

            }

        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][j] * matrixRight[i][j];


                }

            }

        }
        return result;
    }
}






