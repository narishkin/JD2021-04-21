package by.it.nakov.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value, 0, this.value, 0, value.length);
        }
    }

    public Matrix(String strMatrix) {
        String[] rowMatrix = strMatrix.split("}");
        String[][] cellsMatrix = new String[rowMatrix.length][0];

        for (int i = 0; i < rowMatrix.length; i++) {
            cellsMatrix[i] = rowMatrix[i]
                    .replace('{', ' ')
                    .replace('}', ' ')
                    .trim().split(",\\a*");
        }
    }

    @Override
    public String toString() {
        StringBuilder ab1 = new StringBuilder("{");
        String delimiter = "";
        for (double[] element : value) {
            ab1.append("{");
            ab1.append(delimiter).append(Arrays.toString(element));
            ab1.append("}");
        }
        ab1.append("}");
        return ab1.toString();
    }
}
