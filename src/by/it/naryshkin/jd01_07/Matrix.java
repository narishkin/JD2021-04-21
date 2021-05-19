package by.it.naryshkin.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        stringMatrixParser(strMatrix);
    }

    private void stringMatrixParser(String strMatrix) {
        Pattern p1 = Pattern.compile("(\\{).*?(\\})+");
        Matcher m1 = p1.matcher(strMatrix);
        int matrixRowQuantity = 0;
        int matrixColumnQuantity = 0;
        String row = null;
        while (m1.find()) {
            matrixRowQuantity++;
            row = m1.group();
        }
        Pattern p2 = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher m2 = p2.matcher(row);
        while (m2.find()) {
            matrixColumnQuantity++;
        }
        value = new double[matrixRowQuantity][matrixColumnQuantity];
        m1.reset();
        int i = 0;
        int j;
        while (m1.find()) {
            m2 = p2.matcher(m1.group());
            j = 0;
            while (m2.find()) {
                value[i][j] = Double.parseDouble(m2.group());
                j++;
            }
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("},");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("}");

        return sb.toString();
    }
}
