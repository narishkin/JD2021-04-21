package by.it.stain.jd01_09;


abstract class Var implements Opration {
    static Var createVar (String operand){
        operand=operand.trim().replace("\\s+","");
        if(operand.matches(Patterns.SCALAR))
            return new Scalar (operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);

        if(operand.matches(Patterns.MATRIX))
            return new Matrix (operand);
        return null;
    }

     public Var() {
         super();
     }
     @Override
     public Var add(Var other) {
         System.out.println("Operation add"+this+"+"+other+"impossible");
         return null;
     }

     @Override
     public Var sub(Var other) {
         System.out.println("Operation sub"+this+"-"+other+"impossible");
         return null;
     }

     @Override
     public Var mul(Var other) {
         System.out.println("Operation mul"+this+"*"+other+"impossible");
         return null;
     }

     @Override
     public Var div(Var other) {
         System.out.println("Operation div"+this+"/"+other+"impossible");
         return null;
     }

     @Override
    public String toString() {

        return "Abstract Variable";
    }
}
