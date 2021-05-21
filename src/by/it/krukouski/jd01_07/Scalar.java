package by.it.krukouski.jd01_07;

public class Scalar extends Var{
    private final double VALUE;
    public Scalar(double value){
        this.VALUE =value;
        System.out.println(value);
    }

    public Scalar(Scalar scalar){
        VALUE =scalar.VALUE;

    }

    public Scalar(String stringScalar){
        VALUE=Double.parseDouble(stringScalar);
    }

    @Override
    public String toString() {
        return Double.toString(VALUE);
    }
}
