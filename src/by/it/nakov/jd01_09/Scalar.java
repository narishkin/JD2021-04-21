package by.it.nakov.jd01_09;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scl) {
        this.value = scl.value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
