/*Создайте в пакете by.it.familiya.jd01_02 класс TaskA.
        В методе main введите 10 чисел с консоли в массив arr через объект типа
        Scanner. Пример: Scanner scanner=new Scanner(System.in);
        В классе TaskA создайте статические методы
static void step1(int[ ] arr)
static void step2(int[ ] arr)
static void step3(int[ ] arr)
        и вызовите их из метода main. Эти методы решают такие задачи:
        1. Найти самое маленькое и самое большое число массива. Вывести на
        консоль найденные минимум и максимум в одну строку через пробел.
        2. Вывести на консоль те числа, значение которых строго меньше
        среднего арифметического (типа double) в этом массиве.
        3. Найти и вывести номер (т.е. индекс) самого маленького числа.
        Если же таких чисел будет несколько, вывести все найденные индексы
        минимума через пробел в порядке убывания.
 */
package by.it.stain.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int element : array) {


            if (min > element) min = element;
            if (max < element) max = element;


        }
        System.out.println(min + " " + max);
    }


    private static void step2(int[] array) {
        double avg = 0;
        for (int element : array) {
            avg = avg + element;

        }
        avg = avg / array.length;
        for (int element : array) {
            if (element < avg)
                System.out.print(element + " ");


        }


    }


    private static void step3(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (min > element) min = element;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min)
                System.out.print(i + " ");
        }


    }
}
