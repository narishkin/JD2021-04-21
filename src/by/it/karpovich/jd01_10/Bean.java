package by.it.karpovich.jd01_10;

public class Bean {
    @Param(a=11,b=18)
    static double sum(int a, int b) {
        return a+b;
    }

    @Param(a=12,b=119)
    static double max(int a, int b) {
        return a<b?b:a;
    }

    @Param(a=6,b=13)
    double min(int a, int b) {
        return a>b?b:a;
    }

    double avg(int a, int b) {
        return (a+b)/2.0;
    }
}
