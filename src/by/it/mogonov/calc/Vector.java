package by.it.mogonov.calc;



import java.util.Arrays;


public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }


    public Vector(String strVector) {

        String[] token = strVector.replaceAll("[ {}]", "").split(",");
        this.value = new double[token.length];
        for (int i = 0; i < token.length; i++) {
            this.value[i] = Double.parseDouble(token[i]);
        }

    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.sub(other);

    }

    @Override
    public Var mul(Var other) throws CalcException {

        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double res = 0;

            for (int i = 0; i < value.length; i++) {
                res = res + value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        } else
            return super.mul(other);
    }


    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                return null;
            }
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            return super.div(other);
        }
        return super.div(other);
    }


    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            stb.append(delimiter);
            stb.append(element);
            delimiter = ", ";
        }
        stb.append('}');
        return stb.toString();
    }

}