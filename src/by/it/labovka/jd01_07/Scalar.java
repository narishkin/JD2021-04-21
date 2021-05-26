package by.it.labovka.jd01_07;

class Scalar extends Var {
    double d ;

    public double getD() {
        return d;
    }

    public Scalar(double d) {
this.d=d;
    }

    public Scalar(Scalar scalar) {
this.d = scalar.getD();
    }

    public Scalar(String strScalar) {
this.d=Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(this.d);
    }
}
