package by.it.stain.jd01_05;

import static java.lang.Math.sqrt;

public class TaskC {
    public static void main(String[] args) {
        double compare = 3.5;

        int numberOfArray = 0;
        double[] array = new double[numberOfArray];

        int a = 0;
        double[] newArray = new double[a];



        for (double x = 5.33; x <= 9; x += 0.122) {

            array[numberOfArray] = x;
            numberOfArray++;
            if (x > compare) {
                newArray[a] = x;
                a++;
            }

        }

        numberOfArray--;
        a--;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[% -3d]=%-10.4f ",i,array[i]);

        }
        double sum = 0;
        for (int i = 0; i < a; i++) {
            newArray[a] += sum;
        }
        double geometricMean = sqrt(sum);
        System.out.printf("%-5.3f", geometricMean);
    }
}
