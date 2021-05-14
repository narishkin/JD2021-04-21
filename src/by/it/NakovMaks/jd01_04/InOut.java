package by.it.NakovMaks.jd01_04;

public class InOut {
    static double[] getArray(String line) {
        //line ="   1 2 3 4  7 8 12 "
        //String lineWithoutSpaces = line.trim();

        //line ="1 2 3 4  7 8 12"
        String[] valuesStringArray = line.trim().split(" ");

        double[] values = new double[valuesStringArray.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(valuesStringArray[i]);
        }

        return values; //stub = "return null"
    }

    public static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] array, String nameArray, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", nameArray, i, array[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == array.length) System.out.println();
        }
    }
}
