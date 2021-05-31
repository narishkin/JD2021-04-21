package by.it.krukouski.calc;

public class VarCreator {

    private VarCreator(){

    }

    static Var createVar(String string){
        if (string.matches(Patterns.SCALAR)){
            return new Scalar(string);
        }
        else if (string.matches(Patterns.VECTOR)){
            return new Vector(string);
        }
        else if (string.matches(Patterns.MATRIX)){
            return new Matrix(string);
        }
        else {
            System.out.println("ERROR Var" + string);
            return null;
        }
    }

}
