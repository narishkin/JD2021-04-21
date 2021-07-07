package by.it.naryshkin.jd02_06.calc;

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
    ResourceManager resourceManager = ResourceManager.INSTANCE;

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix.length; j++) {
                    resultMatrix[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }

            return new Matrix(resultMatrix);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] resultMatrix = new double[value.length][value[0].length];
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[0].length; j++) {
                        resultMatrix[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(resultMatrix);
            }
        } else {
            return super.add(other);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[0].length; j++) {
                    resultMatrix[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(resultMatrix);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] resultMatrix = new double[value.length][value[0].length];
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[0].length; j++) {
                        resultMatrix[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(resultMatrix);
            }
        } else {
            throw  new CalcException(resourceManager.get(Messages.UNEQUAL_MATRICES_SIZE));
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[value.length][value[0].length];
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[0].length; j++) {
                    resultMatrix[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(resultMatrix);
        } else if (other instanceof Matrix) {
            if (this.value[0].length == ((Matrix) other).value.length) {
                double[][] resultMatrix = new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[0].length; j++) {
                        double sum = 0;
                        for (int k = 0; k < this.value[0].length; k++) {
                            sum = sum + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                        resultMatrix[i][j] = sum;
                    }
                }
                return new Matrix(resultMatrix);
            }
        } else {
            if (this.value.length == ((Vector) other).value.length) {
                double[] resultVector = new double[this.value.length];
                for (int i = 0; i < resultVector.length; i++) {
                    for (int j = 0; j < resultVector.length; j++) {
                        double sum = 0;
                        for (int k = 0; k < resultVector.length; k++) {
                            sum = sum + this.value[i][k] * ((Vector) other).value[k];
                        }
                        resultVector[i] = sum;
                    }
                }
                return new Vector(resultVector);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    private void stringMatrixParser(String strMatrix) {
        Pattern p1 = Pattern.compile(Patterns.VECTOR);
        Matcher m1 = p1.matcher(strMatrix);
        int matrixRowQuantity = 0;
        int matrixColumnQuantity = 0;
        String row = null;
        while (m1.find()) {
            matrixRowQuantity++;
            row = m1.group();
        }
        Pattern p2 = Pattern.compile(Patterns.SCALAR);
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
