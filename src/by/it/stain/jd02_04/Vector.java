package by.it.stain.jd02_04;





import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }
    public Vector(String strVector) {

        stringVector(strVector);
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public Var add(Var other) throws CalcException {
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
    public Var sub(Var other) throws CalcException {
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
    public Var mul(Var other) throws CalcException {
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
    public Var div(Var other) throws CalcException {
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

   public Vector(Vector vector) {
        this.value = vector.value;
    }
    private void stringVector(String strVector){
        StringBuilder sb = new StringBuilder(strVector);
        Pattern p1 = Pattern.compile("(\\d\\.\\d)|(\\d)");
        Matcher m1 = p1.matcher(sb);
        int vectorLength = 0;
        while (m1.find()) {
            vectorLength++;
        }
        value = new double[vectorLength];
        m1.reset();
        int i = 0;
        while (m1.find()) {
            value[i] = Double.parseDouble(m1.group());
            i++;
        }

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
