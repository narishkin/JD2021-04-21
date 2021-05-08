package by.it.khmelov.jd01_04;

public class InOut {


    static double[] getArray(String line) {
        String lineWithoutSpaces = line.trim();
        String[] valuesStringArray = lineWithoutSpaces.split(" ");
        double[] values = new double[valuesStringArray.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(valuesStringArray[i]);
        }
        return values;
    }

    public static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * @param array input data
     * @param nameArray name
     * @param columnCount cols
     */
    public static void printArray(double[] array, String nameArray, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.4f ", nameArray, i, array[i]);
            if (i == array.length - 1 || (i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
    }
}
