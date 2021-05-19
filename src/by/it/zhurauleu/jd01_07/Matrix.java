package by.it.zhurauleu.jd01_07;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix value) {
        this.value = value.value;
    }

    public Matrix(String strMatrix) {
        String line = strMatrix.substring(2, strMatrix.length() - 2);
        String[] strArr = line.split("[}][,][{]");
        double[][] outputArray = new double[strArr.length][strArr[0].split(",").length];
        for (int i = 0; i < strArr.length; i++) {
            String[] strArr2 = strArr[i].split(",");
            int k = 0;
            for (int j = 0; j < strArr2.length; j++) {
                outputArray[i][j] = Double.parseDouble(strArr2[k]);
                k++;
            }
        }
        this.value = outputArray;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            String delimiter = "";
            output.append("{");
            for (int j = 0; j < value[i].length; j++) {
                output.append(delimiter);
                output.append(value[i][j]);
                delimiter = ", ";
            }
            delimiter = "}, ";
            output.append(delimiter);
        }
        output.delete(output.length() - 2, output.length());
        output.append("}");
        return output.toString();
    }

}
