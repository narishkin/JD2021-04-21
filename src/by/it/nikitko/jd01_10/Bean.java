package by.it.nikitko.jd01_10;



public class Bean {

    @Param(a = 90, b = 80)
    static double sum(int first, int second) {
        return first + second;
    }


    @Param(a = 90, b = 80)
    static double max(int first, int second) {
        return first > second ? first : second;
    }

   @Param(a = 90, b = 80)
    double min(int first, int second) {
        return Math.min(first, second);
    }


    double avg(int first, int second) {
        return (first + second) / 2.0;
    }
}
