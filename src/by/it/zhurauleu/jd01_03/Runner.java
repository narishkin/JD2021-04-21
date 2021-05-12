package by.it.zhurauleu.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String line = "1 2 0.445 -123.0 -15.22 949";
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "myArray", 2);
        System.out.println("maximum: " + Helper.findMax(array));
        System.out.println("minimum: " + Helper.findMin(array));
        Helper.sort(array);
        System.out.println("sorted array:");
        InOut.printArray(array);
        double[][] leftMatrix = {{1, 2}, {3, 4}};
        double[][] rightMatrix = {{5, 6}, {7, 8}};
        double[][] result = Helper.mul(leftMatrix, rightMatrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
