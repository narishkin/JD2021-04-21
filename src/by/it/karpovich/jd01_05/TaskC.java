package by.it.karpovich.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        step6();
    }

    private static void step6() {
        double[] mathArray = new double[40];
        for (int i = 0; i < mathArray.length; i++) {
            for (double x = 5.33; x <= 9.0; x += 0.01) {
                mathArray[i] = Math.cbrt((Math.pow(x, 2.0) + 4.5));
                break;

            }
        }
        int counter = 0;
        for (int i = 0; i < mathArray.length; i++) {
            System.out.printf("%1s [%d] = %f\n", "Элемент", i, mathArray[i]);
            if (mathArray[i] > 3.5) {
                counter++;
            }
        }
        double[] moreThanArray = new double[counter];
        double multiplication = moreThanArray[0];
        for (int i = 1; i < moreThanArray.length; i++) {
            multiplication *= moreThanArray[i];
        }
        double averageGeometric = Math.pow(multiplication, 1 / counter);
        System.out.println(averageGeometric);
    }


}
