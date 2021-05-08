package by.it.nikitko.jd01_04;

/**
 * Parse string array to double array. Split spaces at the begin and the end of the array.
 */
public class InOut {
    static double[] getArray(String line) {
        String[] stringArray = line.split(" ");
        double[] result = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = Double.parseDouble(stringArray[i]);
        }
        return result;
    }

    static int[] getIntArray(String line) {
        String[] stringArray = line.split(" ");
        int [] result = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = Integer.parseInt(stringArray[i]);
        }
        return result;
    }

    static void printArray(double[] arr) {
        for (double item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String arrayName, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f", arrayName, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length) {
                System.out.println();
            }
        }
    }
}

