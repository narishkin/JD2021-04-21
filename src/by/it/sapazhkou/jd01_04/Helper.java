package by.it.sapazhkou.jd01_04;

public class Helper {

    static double findMin(double[ ] array){
        if(0== array.length){
            return Double.MIN_VALUE;
        } else {
            double minValue = array[0];
            for (double element : array) {
                if (minValue > element) {
                    minValue = element;
                }
            }
            System.out.println("MIN "+minValue);
            return minValue;
        }
    }

    static double findMax(double[ ] array){
        if(0== array.length){
            return Double.MAX_VALUE;
        } else {
            double maxValue = array[0];
            for (double element : array) {
                if (maxValue < element) {
                    maxValue = element;
                }
            }
            System.out.println("MAX "+maxValue);
            return maxValue;
        }
    }
    /* Сортировка вставками.
    Текущий элемнт сдвигается на позицию (в направлении начала сортировки) в которой условие выполняется
     */
    static void sort(double[ ] array){
        for (int i = 1; i < array.length; i++) {
            double current = array[i];
            int j = i-1;
            while (j>=0 && current < array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        for (double element : array) {
            System.out.print(element+" ");
        }
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] resultArray = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultArray[i]=resultArray[i]+ matrix[i][j]*vector[j];
            }
        }
        for (int i=0;i< resultArray.length;i++) {
            System.out.printf("% 6.2f",resultArray[i]);
        }
        System.out.println();
        return resultArray;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] resultArray = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    resultArray[i][j] = resultArray[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                System.out.printf("[%2d,%2d]=%-6.2f",i,j,resultArray[i][j]);
                System.out.println();
            }
            System.out.println();
        }
        return resultArray;
    }
}
