package by.it.vencerev.jd01_02;
import java.util.Arrays;
import java.util.Scanner;


public class TestA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        array[3]= 169;
        array[7] = 666;
        array[2] = 13;

        double average = 0;
        for(int i=0; i< array.length; i++) {
            average += array[i];//  просто суммируем все числа массива
        }
        average = average/array.length;  // вычисляем среднее деля сумму на кол-во эдементов массива


        double max = -999999990;
        double min = 999999990;
        for(int i=0; i< array.length; i++) {
            double num = array[i];// для удобства =)
            if(num>max)  max = num;
            if(num<min)  min = num;
        }



        System.out.println(min+" "+max); // first task задание первой просто выводим мак и мин
        for(int i=0; i< array.length; i++) {
            if(array[i]< average)  System.out.println(array[i]); // 2 task   выводим все числа которые меньше среднего значения
        }
        for(int i=0; i< array.length; i++) {
            if(array[i] == min)  System.out.println(i); // 3 task   выводим индексы
        }
    }
}
