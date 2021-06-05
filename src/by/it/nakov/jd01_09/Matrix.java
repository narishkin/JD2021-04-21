package by.it.nakov.jd01_09;

import java.util.Arrays;

public class Matrix extends by.it.nakov.jd01_07.Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        String[] strMatrixArr2 = strMatrix.split(" ");
        value = new double[strMatrixArr2.length][];
//        this.value = Arrays.stream(strVectorArr).mapToDouble(Double::parseDouble).toArray();
        for (int i = 0; i < strMatrixArr2.length; i++) {
            for (int j = 0; j < strMatrixArr2[i].length(); j++) {
                String str = strMatrixArr2[i];
                value[i][j] = Double.parseDouble(str);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder ab1 = new StringBuilder("{");
        String delimiter = "";
        for (double[] element : this.value) {
            ab1.append("{");
            ab1.append(delimiter).append(Arrays.toString(element));
            ab1.append("}");
        }
        for (double[] element2 : value) {
            ab1.append("{");
            ab1.append(delimiter).append(Arrays.toString(element2));
            ab1.append("}");
        }
        ab1.append("}");
        return ab1.toString();
    }
}
