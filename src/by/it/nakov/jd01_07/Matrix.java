package by.it.nakov.jd01_07;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix){this.value= matrix.value;}

    Matrix(String strMatrix){}


    @Override
    public String toString() {
        StringBuilder ab = new StringBuilder("{{");
        String delimiter = "";
        for (double[] element : value) {
            ab.append(delimiter).append(element);
            delimiter = ", ";
        }
        ab.append("}}");
        return ab.toString();
    }
}
