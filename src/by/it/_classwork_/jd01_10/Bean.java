package by.it._classwork_.jd01_10;

public class Bean {
    static double sum(int first, int second) {
        return first + second;
    }

    @SuppressWarnings("ManualMinMaxCalculation")
    @Param(a = 90, b = 80)
    static double max(int first, int second) {
        return first > second ? first : second;
    }

    @Param(a = 99, b = 88)
    double min(int first, int second) {
        return Math.min(first, second);
    }

    @Param(a = 9, b = 80)
    double avg(int first, int second) {
        return (first + second) / 2.0;
    }
}
