package by.it.stain.jd01_08;



abstract class Var implements Opration {
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
