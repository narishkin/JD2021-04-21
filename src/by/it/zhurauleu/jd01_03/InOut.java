package by.it.zhurauleu.jd01_03;

public class InOut {
    /**
     *
     * @param line input String
     * @return array of doubles that parsed from input line
     */
    static double[] getArray(String line) {
        String[] stringArray = line.split(" ");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    /**
     *
     * @param arr input array of doubles
     */
    static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    /**
     *
     * @param arr input array of doubles
     * @param name the name of array
     * @param columnCount number of elements in a single row
     */
    static void printArray(double[] arr, String name, int columnCount) {
        System.out.println(name + ":");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%8.2f", arr[i]);
            if ((i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
