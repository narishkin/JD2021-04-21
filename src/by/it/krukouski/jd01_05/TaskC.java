package by.it.krukouski.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        int quantityElement = (int) ((Math.random() * 21) + 20);
        double[] array = new double[quantityElement];
        int i = 0;
        //заполняем массив
        for (double x = 5.33; x <= 9; x += (9.53 / 5.33) / (quantityElement - 1)) {
            if (i >= quantityElement) {
                break;
            }
            double z = Math.cbrt(x * x + 4.5);
            array[i] = z;
            i++;

        }
        //печатаем массив и считаем количество элементов, которые больше значения 3,5
        int a = 0;
        for (int j = 0; j < array.length; j++) {
            System.out.printf("%1s[%d]=%f\n", "v", j, array[j]);
            if (array[j] > 3.5) {
                a++;
            }
        }
        //заполняем итоговый массив с значениями больше 3,5
        double[] resultArray = new double[a];
        int el = 0;
        for (double elementArray : array) {
            if (elementArray > 3.5) {
                resultArray[el] = elementArray;
                el++;
            }

        }
        //печатаем итоговый массив
        for (int j = 0; j < resultArray.length; j++) {
            System.out.printf("%1s[%d]=%f\n", "v", j, resultArray[j]);
        }
    }
}
