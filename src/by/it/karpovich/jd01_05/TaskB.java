package by.it.karpovich.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step5() {
        for (double x = -6; x < 2; x += 0.5) {
            double beta = 0;
            if (x / 2 > -2 && x / 2 <= -1) {
                beta = Math.sin(Math.pow(x, 2));
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                beta = Math.cos(Math.pow(x, 2));
            } else if (x / 2 == 0.2) {
                beta = Math.tan(Math.pow(Math.pow(x, 2), -1));
            } else System.out.println("Вычисление недопустимо");
            double alpha = Math.log10(Math.abs(beta + 2.74));
            System.out.printf("Если x/2 =%.2f ===> alpha =%f\n", x / 2, alpha);
        }
    }

    private static void step4() {
        double a = 0;
        while (a <= 2.0) {
            double y = 0;
            for (int i = 1; i <= 6; i++) {
                y += Math.pow(7, a) - Math.cos(i);
            }
            System.out.printf("a=%1.1f ,y=%f\n", a, y);
            a += 0.2;
        }

    }
}
