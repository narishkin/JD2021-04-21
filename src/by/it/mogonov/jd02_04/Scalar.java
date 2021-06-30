package by.it.mogonov.jd02_04;


class Scalar extends Var {

    private double value;

    public Scalar(double value) { this.value = value; }

    public Scalar(String stringValue) { value = Double.parseDouble(stringValue); }

    public Scalar(Scalar otherScalar) { value = otherScalar.value; }

    public double getValue() { return value;}


        @Override
        public Var add (Var other) throws CalcException {
            if (other instanceof Scalar) {
                double sum = this.value + ((Scalar) other).value;
                return new Scalar(sum);
            }
                return other.add(this);

        }

        @Override
        public Var sub (Var other) throws CalcException {
            if (other instanceof Scalar) {
                double sub = this.value - ((Scalar) other).value;
                return new Scalar(sub);
            }
                return new Scalar(-1).sub(other).add(this);
        }


        @Override
        public Var mul (Var other) throws CalcException {

            if (other instanceof Scalar) {
                double mul = this.value * ((Scalar) other).value;
                return new Scalar(mul);
            }
                return other.mul(this);
        }

        @Override
        public Var div (Var other) throws CalcException {
            if (other instanceof Scalar) {
                double secondOperandValue = ((Scalar)other).value;
                if (secondOperandValue==0) {
                    throw new CalcException("Деление на ноль");
                }
                double div = this.value / secondOperandValue;
                return new Scalar(div);
            }
                return super.div(other);
        }



        @Override
        public String toString () {

            return Double.toString(value);

        }
    }


