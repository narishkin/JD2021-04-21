package by.it.stain.jd02_04;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Matrix extends Var {
    private double[][] value;


    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        stringMatrixParser(strMatrix);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] addMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < addMatrix.length; i++) {
                for (int j = 0; j < addMatrix[i].length; j++) {
                    addMatrix[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }

            return new Matrix(addMatrix);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] addMatrix = new double[value.length][value[0].length];
                for (int i = 0; i < addMatrix.length; i++) {
                    for (int j = 0; j < addMatrix[0].length; j++) {
                        addMatrix[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(addMatrix);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] addMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < addMatrix.length; i++) {
                for (int j = 0; j < addMatrix[i].length; j++) {
                    addMatrix[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }

            return new Matrix(addMatrix);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] addMatrix = new double[value.length][value[0].length];
                for (int i = 0; i < addMatrix.length; i++) {
                    for (int j = 0; j < addMatrix[0].length; j++) {
                        addMatrix[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(addMatrix);
            }
        }
        return super.add(other);

    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] mulMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mulMatrix.length; i++) {
                for (int j = 0; j < mulMatrix.length; j++)
                    mulMatrix[i][j] = this.value[i][j] * ((Scalar) other).getValue();
            }

            return new Matrix(mulMatrix);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] mulMatrix = new double[value.length][value[0].length];
                for (int i = 0; i < mulMatrix.length; i++) {
                    for (int j = 0; j < mulMatrix[0].length; j++) {
                        double sum = 0;
                        for (int k = 0; k < mulMatrix.length; k++) {
                            sum = sum + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                        mulMatrix[i][j] = sum;

                    }
                }
                return new Matrix(mulMatrix);
            }
        } else {
            if (this.value.length == ((Vector) other).getValue().length) {
                double[] mulMatrix = new double[this.value.length];
                for (int i = 0; i < mulMatrix.length; i++) {
                    for (int j = 0; j < mulMatrix.length; j++) {
                        double sum = 0;
                        for (int k = 0; k < mulMatrix.length; k++) {
                            sum = sum + this.value[i][k] * ((Vector) other).getValue()[k];

                        }
                        mulMatrix[i] = sum;


                    }

                }
                return new Vector(mulMatrix);

            }

        }


        return super.mul(other);

    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    private void stringMatrixParser(String strMatrix) {
        Pattern p1 = Pattern.compile("(\\{).*?(\\})+");
        Matcher m1 = p1.matcher(strMatrix);
        int matrixRow = 0;
        int matrixColumn = 0;
        String row = null;
        while (m1.find()) {
            matrixRow++;
            row = m1.group();
        }
        Pattern p2 = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher m2 = p2.matcher(row);
        while (m2.find()) {
            matrixColumn++;
        }
        value = new double[matrixRow][matrixColumn];
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

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("}, ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");

        return sb.toString();
    }
}
