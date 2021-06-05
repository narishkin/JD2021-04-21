package by.it.mogonov.jd01_10;

public class Bean {

    static double sum (int one, int two) { return (one+two);}
@Param(a=13, b=11)
    static double max (int one, int two) { return (one>two ? one : two);}
@Param(a =56, b = 41)
    public double min (int one, int two) { return (one<two ? one : two);}
@Param(a = 73, b = 39)
    public double avg (int one, int two) { return (one+two) / 2.0;}


}