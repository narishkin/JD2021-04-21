package by.it.labovka.jd01_04;

public class InOut {
    static double[ ] getArray(String line)
    {
        String[] str = line.split(" ");
        double[] d = new double[str.length];
        for (int i = 0; i < str.length; i++) {
         d[i]= Double.parseDouble(str[i]);
        }
return d;
    }

    static void printArray(double[ ] arr) {
        for (double v : arr) {
            System.out.println(v);

        }
    }
    static void printArray(double[ ] arr, String name, int columnCount)
    {
        for (int i = 0; i < arr.length; i++) {


            System.out.printf("%s[%-1d]=%-10f ", name,i, arr[i]);
            if((i+1)%columnCount==0|| (i+1)==arr.length) System.out.println();
        }
    }
}
