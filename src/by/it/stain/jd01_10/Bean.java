package by.it.stain.jd01_10;

public class Bean {

     static double  sum(int a,int b){
         return a+b;

     }
    @Param(a = 8,b=12)
    static double max(int a,int b){
         if(a>b){
             return a;
         }
         else return b;
    }
    @Param(a = 32,b=55)
    double min(int a,int b){
        if(a<b){
            return a;
        }
        else return b;
    }
    @Param(a = 26,b=98)
    double avg(int a,int b){
         return (a+b)/2.0;
    }
}
