package by.it.krukouski.jd01_07;

public class Matrix extends Var {
    private final double[][] ARRAY;

    public Matrix(double[][] array) {
        this.ARRAY = array;

    }

    public Matrix(Matrix matrix) {
        ARRAY = matrix.ARRAY;

    }

    public Matrix(String stringMatrix) {
        String line = stringMatrix.replaceAll("[{}]{2,}", "");
        String[] arrayString = line.split("(},\\{)");
        String[][] matrix = new String[arrayString.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = arrayString[i].split(",");
        }
        this.ARRAY = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY[i].length; j++) {
                ARRAY[i][j] = Double.parseDouble(matrix[i][j]);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        String startArray = "{";
        for (int i = 0; i < ARRAY.length; i++) {
            string.append(startArray);
            String space = ", ";
            for (int j = 0; j < ARRAY[i].length; j++) {
                if (j == ARRAY[i].length - 1) {
                    space = "}";
                }
                string.append(ARRAY[i][j]);
                string.append(space);
            }
            if (i < ARRAY.length - 1) {
                string.append(", ");
            }
            if (i == ARRAY.length - 1) {
                string.append("}");
            }
        }
        return string.toString();
    }
}
