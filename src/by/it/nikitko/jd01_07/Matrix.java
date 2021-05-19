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

    public Matrix(String strMatrix) {

        strMatrix = strMatrix.substring(2, strMatrix.length() - 2);
        String[] arrayMatrixString = strMatrix.split("},\\{");
        String[] stringNumbers = arrayMatrixString[0].split(",");
        double[][] tempValue = new double[arrayMatrixString.length][stringNumbers.length];
        for (int i = 0; i < arrayMatrixString.length; i++) {
            stringNumbers = arrayMatrixString[i].split(",");
            for (int j = 0; j < stringNumbers.length; j++) {
                tempValue[i][j] = Double.parseDouble(stringNumbers[j]);
            }
        }
        value = Arrays.copyOf(tempValue, tempValue.length);
    }


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
            if (i != value.length - 1) {
                out.append(", ");
            }
        }
        out.append("}");
        return out.toString();
    }
}
