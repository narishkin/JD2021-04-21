package by.it.sapazhkou.jd02_04;


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
        double[][] value = new double[arrayElementString.length][arrayElementString[0].length - 1];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                value[i][j] = Double.valueOf(arrayElementString[i][j + 1]);
            }
        }
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value.length; j++) {
                sb.append(value[i][j]);
                if (j < value[i].length - 1 && i <= value.length - 1) {
                    sb.append("," + " ");
                } else if (j == value[i].length - 1 && i < value.length - 1) {
                    sb.append("}, ");
                } else {
                    sb.append("}");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {

            double[][] firstOperand = new double[value.length][value[0].length];
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double secondOperand = ((Scalar) other).getValue();

            for (int i = 0; i < firstOperand.length; i++) {
                for (int j = 0; j < firstOperand[i].length; j++) {
                    firstOperand[i][j] = firstOperand[i][j] + secondOperand;
                }
            }
            return new Matrix(firstOperand);
        } else if (other instanceof Matrix) {

            double[][] firstOperand = new double[value.length][value[0].length];
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[][] secondOperand = ((Matrix) other).value;

            if (firstOperand.length == secondOperand.length && firstOperand[0].length == secondOperand[0].length) {
                for (int i = 0; i < firstOperand.length; i++) {
                    for (int j = 0; j < firstOperand[i].length; j++) {
                        firstOperand[i][j] = firstOperand[i][j] + secondOperand[i][j];
                    }
                }
            }
            return new Matrix(firstOperand);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {

            double[][] firstOperand = new double[value.length][value[0].length];
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double secondOperand = ((Scalar) other).getValue();

            for (int i = 0; i < firstOperand.length; i++) {
                for (int j = 0; j < firstOperand[i].length; j++) {
                    firstOperand[i][j] = firstOperand[i][j] - secondOperand;
                }
            }
            return new Matrix(firstOperand);

        } else if (other instanceof Matrix) {

            double[][] firstOperand = new double[value.length][value[0].length];
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[][] secondOperand = ((Matrix) other).value;

            if (firstOperand.length == secondOperand.length && firstOperand[0].length == secondOperand[0].length) {
                for (int i = 0; i < firstOperand.length; i++) {
                    for (int j = 0; j < firstOperand[i].length; j++) {
                        firstOperand[i][j] = firstOperand[i][j] - secondOperand[i][j];
                    }
                }
            }
            return new Matrix(firstOperand);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {

            double[][] firstOperand = new double[value.length][value[0].length];
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double secondOperand = ((Scalar) other).value;
                 for (int i = 0; i < firstOperand.length; i++) {
                    for (int j = 0; j < firstOperand[i].length; j++) {
                        firstOperand[i][j] = firstOperand[i][j] * secondOperand;
                    }

            }
            return new Matrix(firstOperand);

        } else if (other instanceof Vector) {

            double[][] firstOperand = new double[value.length][value[0].length];
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[] secondOperand = ((Vector) other).value;
            double[] mulVector = new double[firstOperand.length];
            if (firstOperand.length == secondOperand.length) {
                for (int i = 0; i < firstOperand.length; i++) {
                    for (int j = 0; j < secondOperand.length; j++) {
                            mulVector[i] = mulVector[i] + firstOperand[i][j] * secondOperand[j];
                    }
                }
            }
            return new Vector(mulVector);

        } else if (other instanceof Matrix) {

            double[][] firstOperand = new double[value.length][value[0].length];
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[][] secondOperand = ((Matrix) other).value;
            double[][] mulMatrix = new double[firstOperand.length][secondOperand[0].length];
            if (firstOperand.length == secondOperand[0].length) {
                for (int i = 0; i < firstOperand.length; i++) {
                    for (int j = 0; j < secondOperand[0].length; j++) {
                        for (int k = 0; k < secondOperand.length; k++) {
                            mulMatrix[i][j] = mulMatrix[i][j] + firstOperand[i][k] * secondOperand[k][j];
                        }
                    }
                }


            }
            return new Matrix(mulMatrix);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {

        if (other instanceof Scalar) {

        }
        return super.div(other);
    }
}
