package by.it.stain.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }



    private static void step1() {

        for (double a = 0; a <= 2.001; a += 0.2) {
            double sum = pow(7, a) * 6;
            for (int k = 1; k <= 6; ++k)
                sum -= cos(k);

            System.out.printf("a=%-16.6f sum=%-16.6f\n", a, sum);


        }


    }
    private static void step2() {
        double compare = 0.2;
        for (double x = -6; x<2; x+=0.5){
            if(x/2>-2 || x/2<=-1){
                double a = log10(abs(sin(x*x)+2.74));
                System.out.printf("x=%-16.6f a=%16.6f\n",x,a);
            }
            else if(x/2 > -1|| x/2<compare){
                double a = log10(abs(cos(x*x)+2.74));
                System.out.printf("x=%-16.6f a=%16.6f\n",x,a);

            }
            else if(x/2== compare){
                double a = log10(abs((tan(x*x)/1)+2.74));
                System.out.printf("x=%-16.6f a=%16.6f\n",x,a);

            }
            else{
                System.out.println("Вычисления не возможны!!!");
            }
        }

    }

}

