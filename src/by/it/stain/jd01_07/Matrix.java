package by.it.stain.jd01_07;


import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String string = strMatrix.replaceAll("[{}]", "");


        String[] array1 = string.split(",");

        String[][] value = new String[array1.length][];
        for (int i = 0; i < array1.length; i++) {

            value[i] = array1[i].split(", ");


        }


        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {

                this.value[i][j] = Double.parseDouble(value[i][j]);
                System.out.println(value[i][j]);

            }
        }


    }

    @Override
    public String toString() {
        StringBuilder outVector = new StringBuilder("{");
        String separator = ",";
        String space = "";

        for (int i = 0; i < value.length; i++) {
            outVector.append("{");
            for (int j = 0; j < value[i].length; j++) {
                if (j > 0) {
                    outVector.append(value[i][j]);
                } else {
                    outVector.append(value[i][j]).append(separator);
                }


            }
            outVector.append("}");
            if (value.length - 1 == i) {
                outVector.append(space);


            } else {
                outVector.append(separator);
            }
        }


        outVector.append("}");

        return outVector.toString();
    }
}
