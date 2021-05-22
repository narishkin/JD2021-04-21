package by.it.stain.jd01_08;





import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] += secondValue;
            }
            return new Vector(firstValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] += secondValue[i];
            }
            return new Vector(firstValue);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] -= secondValue;
            }
            return new Vector(firstValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] -= secondValue[i];
            }
            return new Vector(firstValue);
        }
        return super.sub(other);

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] *=secondValue;
            }
            return new Vector(firstValue);
        } else if (other instanceof Vector) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double[] secondValue = ((Vector) other).value;
            double mul = 0;
            for (int i = 0; i < firstValue.length; i++) {
                mul+=firstValue[i]*secondValue[i];

            }
            return new Scalar(mul);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] firstValue = Arrays.copyOf(value, value.length);
            double secondValue = ((Scalar) other).getValue();
            if (secondValue==0) {
                System.out.println("Division impossible");
            }
            else{

            for (int i = 0; i < firstValue.length; i++) {
                firstValue[i] /= secondValue;
            }
            return new Vector(firstValue);
        }
            if (other instanceof Vector) {
                System.out.println("Division impossible");
            }

        }
        return super.div(other);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {
        StringBuilder outVector = new StringBuilder("{");
        String space = "";
        for (double element : value) {
            outVector.append(space);
            outVector.append(element);
            space = ", ";
        }
        outVector.append("}");

        return outVector.toString();
    }
}
