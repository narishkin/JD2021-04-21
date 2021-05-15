package by.it.naryshkin.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        String[] stringArray = line.split(" ");
        double[] array = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Double.parseDouble(stringArray[i]);
        }
        return array;
    }

    static void printArray(double arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int ColumnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%7.3f    ", name, i, arr[i]);
            if ((i + 1) % ColumnCount == 0 || (i + 1) == arr.length) {
                System.out.println();
            }
        }
    }

    static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("[% -3d]=%7.3f    ", i, matrix[i][j]);

            }
            System.out.println();
        }
    }


}
