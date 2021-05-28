package by.it.nikitko.jd01_10;


public class Bean {

    //public Bean(int left,int right) {
      //  this.left=left;
      //  this.right=right;
   // }

    @Param(a=10,b=23)
     double sum(int left, int right) {
        return left + right;
    }

    static double max(int left, int right) {
        return Math.max(left,right);
    }

    @Param(a=100,b=-2)
    static double min(int left, int right) {
        return Math.min(left,right);
    }

    @Param(a=63,b=75)
    double avg(int left, int right) {
        return sum(left, right)/2.0;
    }
}
