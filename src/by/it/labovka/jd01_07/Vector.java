package by.it.labovka.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    double[] value ;

 public double[] getValue() {
  return value;
 }

 Vector(double[ ] value)
 {
this.value = value;
 }

 Vector(Vector vector)
 {
this.value = vector.getValue();
 }



 Vector(String strVector)
 {

  String[] str = strVector.trim().substring(1,strVector.length()-1).split(",");

  double[] a = new double[str.length];
  for (int i = 0; i < str.length; i++) {
      a[i] = Double.parseDouble(str[i]);
     }

  this.value = a;
//  for (int i = 0; i <value.length ; i++) {
//   System.out.println(value[i]);
// //  System.out.println(value.length);
//  }

 }
 @Override
 public String toString() {
  StringBuilder sb = new StringBuilder("{");
  String delimeter = "";
  for(double s : value)
  {
   sb.append(delimeter).append(s);
   delimeter = ", ";
  }
  sb.append("}");
  return sb.toString();
 }
}
