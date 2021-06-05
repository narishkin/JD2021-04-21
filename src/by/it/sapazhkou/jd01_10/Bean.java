package by.it.sapazhkou.jd01_10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Bean {

    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 3, b = 4)
    double max(int a, int b) {
        return a > b ? a : b;
    }
    @Param(a = 3, b = 4)
    static double min(int a, int b) {
        return a < b ? a : b;
    }
    @Param(a = 3, b = 4)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
