package by.it.labovka.jd01_07;

public class Matrix extends Var{
    double[][] m;

    public double[][] getM() {
        return m;
    }

    Matrix(double[ ][ ] value)
    {

    }
    Matrix(Matrix matrix)
    {
this.m = matrix.getM();
    }

    Matrix(String strMatrix)
    {

    }
}
