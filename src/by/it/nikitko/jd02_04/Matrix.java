package by.it.nikitko.jd02_04;


import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[0].length);
        }
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {

        strMatrix = strMatrix.substring(2, strMatrix.length() - 2);
        String[] arrayMatrixString = strMatrix.split("}, *\\{");
        String[] stringNumbers = arrayMatrixString[0].split(", *");
        double[][] tempValue = new double[arrayMatrixString.length][stringNumbers.length];
        for (int i = 0; i < arrayMatrixString.length; i++) {
            stringNumbers = arrayMatrixString[i].split(", *");
            for (int j = 0; j < stringNumbers.length; j++) {
                tempValue[i][j] = Double.parseDouble(stringNumbers[j]);
            }
        }
       value = Arrays.copyOf(tempValue, tempValue.length);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] addMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < addMatrix.length; i++) {
                addMatrix[i] = Arrays.copyOf(this.value[i], this.value.length);
            }
            for (int i = 0; i < addMatrix.length; i++) {
                for (int j = 0; j < addMatrix.length; j++) {
                    addMatrix[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(addMatrix);
        }
        if (other instanceof Matrix) {
            //getting Matrix size and compatibility check
            double[][] addMatrixA = new double[this.value.length][this.value[0].length];
            double[][] addMatrixB = new double[((Matrix) other).value.length][((Matrix) other).value[0].length];

            if (addMatrixA.length == addMatrixB.length && addMatrixA[0].length == addMatrixB[0].length) {
                double[][] addMatrixC = new double[addMatrixA.length][addMatrixA[0].length];

                //Matrix copying
                for (int i = 0; i < addMatrixA.length; i++) {
                    addMatrixA[i] = Arrays.copyOf(this.value[i], this.value.length);
                }
                for (int i = 0; i < addMatrixB.length; i++) {
                    addMatrixB[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value.length);
                }
                // Add matrixA for matrixB
                for (int i = 0; i < addMatrixA.length; i++) {
                    for (int j = 0; j < addMatrixA.length; j++) {
                        addMatrixC[i][j] = addMatrixA[i][j] + addMatrixB[i][j];
                    }
                }
                return new Matrix(addMatrixC);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] subMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < subMatrix.length; i++) {
                subMatrix[i] = Arrays.copyOf(this.value[i], this.value.length);
            }
            for (int i = 0; i < subMatrix.length; i++) {
                for (int j = 0; j < subMatrix.length; j++) {
                    subMatrix[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(subMatrix);
        }
        if (other instanceof Matrix) {
            //getting Matrix size and compatibility check
            double[][] subMatrixA = new double[this.value.length][this.value[0].length];
            double[][] subMatrixB = new double[((Matrix) other).value.length][((Matrix) other).value[0].length];

            if (subMatrixA.length == subMatrixB.length && subMatrixA[0].length == subMatrixB[0].length) {
                double[][] subMatrixC = new double[subMatrixA.length][subMatrixA[0].length];

                //Matrix copying
                for (int i = 0; i < subMatrixA.length; i++) {
                    subMatrixA[i] = Arrays.copyOf(this.value[i], this.value.length);
                }
                for (int i = 0; i < subMatrixB.length; i++) {
                    subMatrixB[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value.length);
                }
                // Add matrixA for matrixB
                for (int i = 0; i < subMatrixA.length; i++) {
                    for (int j = 0; j < subMatrixA.length; j++) {
                        subMatrixC[i][j] = subMatrixA[i][j] - subMatrixB[i][j];
                    }
                }
                return new Matrix(subMatrixC);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {

        if (other instanceof Scalar) {

            double[][] mulMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mulMatrix.length; i++) {
                mulMatrix[i] = Arrays.copyOf(this.value[i], this.value.length);
            }
            for (int i = 0; i < mulMatrix.length; i++) {
                for (int j = 0; j < mulMatrix[0].length; j++) {
                    mulMatrix[i][j] = mulMatrix[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mulMatrix);
        }


            if (other instanceof Vector) {
                double[] mulVector = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);

                double[][] mulMatrix = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < mulMatrix.length; i++) {
                    mulMatrix[i] = Arrays.copyOf(this.value[i], this.value.length);
                }
                if (mulMatrix[0].length == mulVector.length) {
                    double[] mulResult = new double[mulVector.length];
                    for (int i = 0; i < mulMatrix.length; i++) {
                        for (int j = 0; j < mulVector.length; j++) {
                            mulResult[i] = mulResult[i] + mulMatrix[i][j] * mulVector[j];
                        }
                    }
                    return new Vector(mulResult);
                }
            }
            if (other instanceof Matrix) {
                //getting Matrix size and compatibility check
                double[][] mulMatrixA = new double[this.value.length][this.value[0].length];
                double[][] mulMatrixB = new double[((Matrix) other).value.length][((Matrix) other).value[0].length];

                if (mulMatrixA[0].length == mulMatrixB.length) {
                    double[][] mulMatrixC = new double[mulMatrixA.length][mulMatrixA[0].length];

                    //Matrix copying
                    for (int i = 0; i < mulMatrixA.length; i++) {
                        mulMatrixA[i] = Arrays.copyOf(this.value[i], this.value.length);
                    }
                    for (int i = 0; i < mulMatrixB.length; i++) {
                        mulMatrixB[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value.length);
                    }


                    // Multiplication matrixA for matrixB
                    for (int i = 0; i < mulMatrixA.length; i++) {
                        for (int j = 0; j < mulMatrixB[0].length; j++) {
                            for (int k = 0; k < mulMatrixB.length; k++) {
                                mulMatrixC[i][j] = mulMatrixC[i][j] + mulMatrixA[i][k] * mulMatrixB[k][j];
                            }
                        }
                    }
                    return new Matrix(mulMatrixC);
                }
            }
            return super.sub(other);
        }

        @Override
        public Var div (Var other) throws CalcException {
            return super.div(other);
        }

        public String toString () {

            StringBuilder out = new StringBuilder();
            out.append("{");
            for (int i = 0; i < value.length; i++) {
                out.append("{");
                String delimiter = ("");
                for (int j = 0; j < value[0].length; j++) {
                    out.append(delimiter);
                    out.append(value[i][j]);
                    delimiter = (", ");
                }
                out.append("}");
                if (i != value.length - 1) {
                    out.append(", ");
                }
            }
            out.append("}");
            return out.toString();
        }
    }
