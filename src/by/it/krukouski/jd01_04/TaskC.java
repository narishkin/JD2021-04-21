package by.it.krukouski.jd01_04;

public class TaskC {
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstIndex = array[0];
        double lastIndex = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        System.out.println();
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstIndex) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lastIndex) {
                System.out.println("Index of last element=" + i);
                break;

            }

        }


    }
}
