package by.it.stain.jd02_04;

public class VarCreator {
    private VarCreator(){}

    static Var get(String stringVar) throws CalcException{
        if(stringVar.matches(Patterns.SCALAR)){
            return new Scalar(stringVar);
        }else if (stringVar.matches((Patterns.VECTOR))){
            return new Vector(stringVar);
        }else if (stringVar.matches(Patterns.MATRIX)){
            return new Matrix(stringVar);
        }else{
            if(VarRepo.contain(stringVar)){
                return VarRepo.load(stringVar);
            }else {
                throw new CalcException("unknown"+stringVar);
            }
        }
    }
}
