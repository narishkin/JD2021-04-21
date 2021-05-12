package by.it.naryshkin.jd01_03;

public class Helper {
    /**
     * Finding of minimum value
     *
     * @param arr
     * @return
     */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        return min;
    }

    /**
     * Finding of maximum value.
     *
     * @param arr
     * @return
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    /**
     * Array bubble sorting
     *
     * @param arr fdsfds
     */
    static void sort(double[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                }
            }
            for (int j = (arr.length - i - 2); j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    double buffer = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Multiplication of Matrix on Vector
     * @param A Matrix A
     * @param v Vector
     * @return Result of Multiplication
     */
    static double[ ] mul(double[ ][ ] A, double[ ] v){
        double[] c = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <v.length ; j++) {
                c[i] = c[i] + A[i][j]*v[j];
            }
        }
        return c;
    }

    /**
     * Multiplication of two Matrices A * B = C:
     * @param A Matrix A
     * @param B Matrix B
     * @return Resulting Matrix C
     * @link {www.google.by}
     */
    static double[ ][ ] mul(double[ ][ ] A, double[ ][ ] B){
        double[][] C = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    C[i][j] = C[i][j]+A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }
}
