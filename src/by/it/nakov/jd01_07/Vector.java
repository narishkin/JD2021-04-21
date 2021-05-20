package by.it.nakov.jd01_07;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(String str) {
//        this.value = .parseDouble(str);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {
        StringBuilder ab = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            ab.append(delimiter).append(element);
            delimiter = ", ";
        }
        ab.append("}");
        return ab.toString();
    }
}


