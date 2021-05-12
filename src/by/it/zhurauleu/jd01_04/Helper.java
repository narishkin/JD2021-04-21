package by.it.zhurauleu.jd01_04;

public class Helper {
    /**
     *
     * @param arr input array of doubles
     * @return minimum value of elements in array
     */
    static double findMin(double[] arr) {
        double minimum = arr[0];
        for (double element : arr) {
            if (element < minimum) {
                minimum = element;
            }
        }
        return minimum;
    }

    /**
     *
     * @param arr input array of doubles
     * @return maximum value of elements in array
     */
    static double findMax(double[] arr) {
        double maximum = arr[0];
        for (double element : arr) {
            if (element > maximum) {
                maximum = element;
            }
        }
        return maximum;
    }

    /**
     *
     * @param arr input array of doubles
     */
    static void sort(double[] arr) {
        double buffer;
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }

    /**
     *
     * @param matrix input matrix
     * @param vector input vector
     * @return result vector of matrix multiplication by vector
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    /**
     *
     * @param matrixLeft input matrix
     * @param matrixRight input matrix
     * @return result of multiplication matrices
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[i].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result;
    }
}

