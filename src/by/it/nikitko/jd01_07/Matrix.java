package by.it.nikitko.jd01_07;


import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[0].length);
        }
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix (String strMatrix) {

    }
//
//        this.value = Arrays.stream(strMatrix.substring(1, strMatrix.length()-1).split(","))
//                .map(String::trim).mapToDouble(Double::parseDouble).toArray();
//






    public String toString() {

        StringBuilder out = new StringBuilder();
        out.append("{");
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            String delimiter = ("");
            for (int j = 0; j < value[0].length; j++) {
                out.append(delimiter);
                out.append(value[i][j]);
                delimiter = (", ");
            }
            out.append("}");
            if (i!= value.length-1){
                out.append(", ");
            }
        }
        out.append("}");
        return out.toString();
    }
}
