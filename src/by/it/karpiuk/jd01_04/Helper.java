package by.it.karpiuk.jd01_04;

public class Helper {
    static double findMin(double[ ] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (min > arr[i])
                min = arr[i];


        }
        return min;
    }
    static double findMax(double[ ] arr){
        double max=arr[0];
            for (int i = 0; i < arr.length; i++) {

                        if(max<arr[i])
                            max=arr[i];
            }
            return max;
        }



    public static void sort (double[] arr){
            for (int last = arr.length-1; last > 1 ; last--) {
                for (int i = 0; i < last; i++) {
                    if (arr[i] > arr[i+1]){
                        double buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
        }

}

