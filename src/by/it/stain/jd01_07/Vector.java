package by.it.stain.jd01_07;

import java.util.Arrays;

class Vector extends Var {
  private double[] value;

  public Vector(double[] value) {
   this.value = Arrays.copyOf(value,value.length);
  }
   Vector (String strVector){

    String string = strVector.replaceAll("[{}]", "");
    String[] vector = string.split(",");
    this.value=new double[vector.length];
    for (int i = 0; i < value.length; i++) {
     value[i]=Double.parseDouble(vector[i]);
    }
     




  }
  Vector(Vector vector){
   this.value = vector.value;
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
