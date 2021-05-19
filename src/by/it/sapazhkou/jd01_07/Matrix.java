package by.it.sapazhkou.jd01_07;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Matrix extends Var {

    double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String strMatrix) {
        Pattern pattern = Pattern.compile("\\}\\,");
        String[] arraySubString = pattern.split(strMatrix);
        String[][] arrayElementString = new String[arraySubString.length][0];

        for (int i = 0; i < arraySubString.length; i++) {
            Pattern pattern1 = Pattern.compile("[^\\d+\\.]+");
            arrayElementString[i] = pattern1.split(arraySubString[i]);
        }
        double[][] value = new double[arrayElementString.length][arrayElementString[0].length-1];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                value[i][j]=Double.valueOf(arrayElementString[i][j+1]);
            }
        }
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < value.length; i++) {
            sb.append("{ ");
            for (int j = 0; j < value.length; j++) {
                sb.append(value[i][j]);
                if (j < value[i].length - 1 && i <= value.length - 1) {
                    sb.append("," + " ");
                } else if (j == value[i].length - 1 && i < value.length - 1) {
                    sb.append(" " + " }, ");
                } else {
                    sb.append(" " + " }");
                }
            }
        }
        sb.append(" }");
        return sb.toString();
    }
}
