package by.it.nikitko.jd01_05;

public class Helper {

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max+1 - min)) + min);
    }

    public static void calculateGeometricMeanOfNumbers(double[] array) {
        double geometricMeanOfNumbers = 1;
        for (double v : array) {
            geometricMeanOfNumbers = geometricMeanOfNumbers * v;
        }
        geometricMeanOfNumbers = Math.pow(geometricMeanOfNumbers, (1.0 / array.length));
        System.out.printf("Geometric mean of numbers array B = %4.2f %n", geometricMeanOfNumbers);

    }


    public static void printIntArray(int[] arr, String arrayName, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10d", arrayName, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length) {
                System.out.println();
            }
        }
    }
}
