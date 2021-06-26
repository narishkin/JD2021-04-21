package by.it.marusich.jd01_09;

import java.util.Arrays;

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
        String[] arrayString = line.split("(},\\s?\\{)");
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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrix[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double scalar = ((Scalar) other).getScalar();
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] += scalar;
                }

            }
            return new Matrix(resultMatrix);
        } else if (other instanceof Vector) {
            System.out.println("Sum impossible");
        } else if (other instanceof Matrix) {
            double[][] resultMatrixFirst = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrixFirst[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double[][] resultMatrixSecond = ((Matrix) other).ARRAY;
            if (resultMatrixFirst.length == resultMatrixSecond.length && resultMatrixFirst[0].length == resultMatrixSecond[0].length) {
                for (int i = 0; i < resultMatrixFirst.length; i++) {
                    for (int j = 0; j < resultMatrixFirst[i].length; j++) {
                        resultMatrixFirst[i][j] += resultMatrixSecond[i][j];
                    }
                }
            }
            return new Matrix(resultMatrixFirst);

        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrix[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double scalar = ((Scalar) other).getScalar();
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] -= scalar;
                }

            }
            return new Matrix(resultMatrix);
        }

        if (other instanceof Vector) {
            System.out.println("Sum impossible");
        }

        if (other instanceof Matrix) {
            double[][] resultMatrixFirst = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrixFirst[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double[][] resultMatrixSecond = ((Matrix) other).ARRAY;
            if (resultMatrixFirst.length == resultMatrixSecond.length && resultMatrixFirst[0].length == resultMatrixSecond[0].length) {
                for (int i = 0; i < resultMatrixFirst.length; i++) {
                    for (int j = 0; j < resultMatrixFirst[i].length; j++) {
                        resultMatrixFirst[i][j] -= resultMatrixSecond[i][j];
                    }
                }
            }
            return new Matrix(resultMatrixFirst);

        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrix[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double scalar = ((Scalar) other).getScalar();
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] *= scalar;
                }
            }
            return new Matrix(resultMatrix);
        }

        if (other instanceof Vector) {
            double[][] resultMatrix = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrix[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double[] totalMatrix = new double[this.ARRAY.length];
            double[] vector = ((Vector) other).getARRAY();
            if (resultMatrix.length == vector.length) {
                for (int i = 0; i < totalMatrix.length; i++) {
                    for (int j = 0; j < vector.length; j++) {
                        totalMatrix[i] = totalMatrix[i] + resultMatrix[i][j] * vector[j];
                    }
                }
            }
            return new Vector(totalMatrix);

        }

        if (other instanceof Matrix) {
            double[][] resultMatrixFirst = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrixFirst[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double[][] secondMatrix = ((Matrix) other).ARRAY;
            double[][] matrixResult = new double[resultMatrixFirst.length][secondMatrix[0].length];
            if (resultMatrixFirst.length == secondMatrix[0].length) {
                for (int i = 0; i < resultMatrixFirst.length; i++) {
                    for (int j = 0; j < secondMatrix[0].length; j++) {
                        for (int k = 0; k < resultMatrixFirst[0].length; k++) {
                            matrixResult[i][j] = matrixResult[i][j] + resultMatrixFirst[i][k] * secondMatrix[k][j];
                        }
                    }
                }
            }
            return new Matrix(matrixResult);

        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatrix = new double[this.ARRAY.length][this.ARRAY[0].length];
            for (int i = 0; i < this.ARRAY.length; i++) {
                for (int j = 0; j < this.ARRAY[i].length; j++) {
                    resultMatrix[i] = Arrays.copyOf(this.ARRAY[i], this.ARRAY[i].length);
                }
            }
            double scalar = ((Scalar) other).getScalar();
            if (scalar == 0) {
                System.out.println("Division by zero");
            } else {
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[i].length; j++) {
                        resultMatrix[i][j] += scalar;
                    }
                }
            }
            return new Matrix(resultMatrix);
        }

        if (other instanceof Vector) {
            System.out.println("Operation impossible");
        }

        if (other instanceof Matrix) {
            System.out.println("Operation impossible");
        }
        return super.div(other);
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