package by.it.marusich.jd01_05;

public class TaskA {
    public static void main(String[]args) {
        step1();
    }
    private static void  step1(){
        double a = 756.13;
        double x = 0.3;
        double part1 = Math.cos(Math.pow(x*x+ Math.PI/6,5));
        double part2 = Math.sqrt(x* Math.pow(a,3));
        double part3 = Math.log(Math.abs((a-1.13 * x)/4));
        double z = part1 - part2 - part3;
        System.out.printf("A=%-8.4f X=%3.1f Z=%-12.6f", a, x, z);
    }


}
