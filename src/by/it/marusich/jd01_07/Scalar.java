package by.it.marusich.jd01_07;

public class Scalar extends Var{
    private double value;
    public Scalar(double value){
        this.value = value;
    }
    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }
    public Scalar(Object otherScalar){
        value = Double.parseDouble(otherScalar.toString());
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}

