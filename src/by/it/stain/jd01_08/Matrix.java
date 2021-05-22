package by.it.stain.jd01_08;


import java.util.Arrays;


class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

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


            }
        }


    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] firstValue = new double[this.value.length][this.value[0].length];
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                for (int j = 0; j < firstValue[i].length; j++) {
                    firstValue[i][j] = firstValue[i][j] + secondValue;

                }

            }
            return new Matrix(firstValue);
        }
        if (other instanceof Vector) {
            System.out.println("Operation impossible");
        }
        if (other instanceof Matrix) {
            double[][] firstValue = this.value;
            double[][] secondValue = ((Matrix) other).value;
            if (firstValue.length == secondValue.length && firstValue[0].length == secondValue[0].length) {
                for (int i = 0; i < firstValue.length; i++) {
                    for (int j = 0; j < firstValue[i].length; j++) {
                        firstValue[i][j] = firstValue[i][j] + secondValue[i][j];

                    }

                }
            }
            return new Matrix(firstValue);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder outVector = new StringBuilder("{");
        String separator = ",";
        String space = "";

        for (int i = 0; i < value.length; i++) {
            outVector.append("{");
            for (int j = 0; j < value.length; j++) {
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
