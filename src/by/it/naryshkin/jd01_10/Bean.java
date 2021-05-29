package by.it.naryshkin.jd01_10;


public class Bean {
    @Param(a = 2, b = 5)
    static double sum(int a, int b) {
        return a + b;

    }

    @Param(a = 2, b = 5)
    static double avg(int a, int b) {
        return (double) (a + b) / 2;

    }


    double max(int a, int b) {
        return a > b ? a : b;

    }
    @Param(a = 2, b = 5)
    double min(int a, int b) {
        return Math.min(a, b);

    }
}
