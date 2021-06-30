package by.it.marusich.jd01_09;




public class VarCreator {

    static Operation getVar(String stringVar) {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)) {
            return new Matrix(stringVar);
        } else {
            System.out.println("cannot create Var from " + stringVar);
            return null;
        }
    }
}