package by.it.voronko.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
    if (0==arr.length) {
        return Double.MIN_VALUE;
    }
    else {
        double min=arr[0];
        for (double m : arr) if (min > m) min = m;
        return min;
    }
    }


    static double findMax(double[ ] arr){
                   if (0==arr.length) {
                return Double.MAX_VALUE;
            }
            else {
                double max=arr[0];
                for (double m : arr) if (max < m) max = m;
                return max;
            }

    }
    static void sort(double[ ] arr){
     boolean swap;
     double lastElment= arr.length-1;
     do { swap=false;
         for (int i = 0; i < lastElment; i++) {
             if (arr[i]>arr[i+1]){
                 double buffer=arr[i];
                 arr[i]=arr[i+1];
                 arr[i+1]=buffer;
                 swap=true;
             }
             
         }
        lastElment--;
     } while (swap);
    }
}
