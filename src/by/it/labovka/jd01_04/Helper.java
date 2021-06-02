package by.it.labovka.jd01_04;

public class Helper {
    static double findMin(double[ ] arr)
    {
        double min=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]<min) min = arr[i];
        }
        return min;
    }
    static double findMax(double[ ] arr)
    {
        double max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]>max) max = arr[i];
        }
        return max;
    }
    static void sort(double[ ] arr)
    {
        Boolean isOver = false;
        while(!isOver) {
            isOver=true;
            for (int i = 1; i < arr.length; i++) {

                if (arr[i] < arr[i - 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isOver = false;
                }
            }
        }
    }
}
