package by.it._classwork_.jd01_09;

public class VarCreator {

    private VarCreator() {
    }

    static Var get(String stringVar) {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)) {
            return new Matrix(stringVar);
        } else {
            System.out.println("Error get for " + stringVar);
            return null;
        }
    }
}
