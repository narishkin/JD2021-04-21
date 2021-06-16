package by.it.sapazhkou.calc;

import java.util.Arrays;

public class Vector extends Var {

    double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(String strVector) {

        String[] arrayElement = strVector.split("[^\\d+\\.]+");
        value = new double[arrayElement.length - 1];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.valueOf(arrayElement[i + 1]);
        }
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(Double.toString(value[i]));
            if (i < value.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] firstOperand = Arrays.copyOf(value, value.length);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = firstOperand[i] + secondOperand;
            }
            return new Vector(firstOperand);
        } else if (other instanceof Vector) {
            double[] firstOperand = Arrays.copyOf(value, value.length);
            double[] secondOperand = ((Vector) other).value;
            if (firstOperand.length == secondOperand.length) {
                for (int i = 0; i < firstOperand.length; i++) {
                    firstOperand[i] = firstOperand[i] + secondOperand[i];
                }
                return new Vector(firstOperand);
            }
            System.out.println("Операнды имею разные размеры, операция не возможна");
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] firstOperand = Arrays.copyOf(value, value.length);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = firstOperand[i] - secondOperand;
            }
            return new Vector(firstOperand);
        } else if (other instanceof Vector) {
            double[] firstOperand = Arrays.copyOf(value, value.length);
            double[] secondOperand = ((Vector) other).value;
            if (firstOperand.length == secondOperand.length) {
                for (int i = 0; i < firstOperand.length; i++) {
                    firstOperand[i] = firstOperand[i] - secondOperand[i];
                }
                return new Vector(firstOperand);
            }
            System.out.println("Операнды имею разные размеры, операция не возможна");
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] firstOperand = Arrays.copyOf(value, value.length);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = firstOperand[i] * secondOperand;
            }
            return new Vector(firstOperand);
        } else if (other instanceof Vector) {
            double[] firstOperand = Arrays.copyOf(value, value.length);
            double[] secondOperand = ((Vector) other).value;
            if (firstOperand.length == secondOperand.length) {
                double result = 0;
                for (int i = 0; i < firstOperand.length; i++) {
                    firstOperand[i] = firstOperand[i] * secondOperand[i];
                    result = result + firstOperand[i];
                }
                return new Scalar(result);
            }
            System.out.println("Операнды имею разные размеры, операция не возможна");
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] firstOperand = Arrays.copyOf(value, value.length);
            double secondOperand = ((Scalar) other).getValue();
            if (secondOperand == 0) {
                System.out.println("Деление на ноль, опреация не возможна");
            } else {
                for (int i = 0; i < firstOperand.length; i++) {
                    firstOperand[i] = firstOperand[i] / secondOperand;
                }
                return new Vector(firstOperand);
            }
        }
        return super.div(other);
    }

}
