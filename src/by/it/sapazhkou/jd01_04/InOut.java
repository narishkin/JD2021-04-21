package by.it.sapazhkou.jd01_04;

public class InOut {
    static double[] getArray(String line) {

        String[] stringArray = line.split(" ");

        double[] resultArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            resultArray[i] = Double.parseDouble(stringArray[i]);
        }
        return resultArray;
    }

    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.println(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[ ] array, String name, int columnCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f",name,i,array[i]);
            if ((0==(i+1)%columnCount) || (array.length==i+1)){
                System.out.println();
            }
        }
    }
}
