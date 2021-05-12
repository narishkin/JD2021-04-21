package by.it.nikitko.jd01_01;

import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1.  Метод getWeight(int weight) должен быть статическим.
2.  Метод getWeight должен возвращать значение типа double.
3.  Метод getWeight должен ОБЯЗАТЕЛЬНО округлять до сотых возвращаемое значение
    типа double внутри самого метода.
4.  Метод getWeight не должен ничего выводить на экран.
5.  Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.
6.  Если получится, то пока не используйте в getWeight методы стандартной библиотеки
    (round, ceil, printf, format, и т.п). Возможностей самого языка вполне достаточно.

Пример:

Ввод:
75

Вывод:
29.51

*/
class TaskC3 {
    public static double getWeight(int weight){

        //Константы ускорения свобоного падения
        final double gEarth = 9.81;
        final double gMars = 3.86;

        // Расчет веса на Марсе
        double weightMars=weight/gEarth*gMars;

        //Перенос 2-х дробных разрядов в целую часть
        weightMars =weightMars*100;

        //Преобразование double в int и отбрасывание дробной части.
        int a = (int) (weightMars);

        //Проверка на потерю точности в последнем знаке после преобразования
        double b = weightMars-a; // Дробный остаток
        if (b>=0.5){
            a++;
        }

        weightMars=a;
        weightMars=weightMars/100;

        return weightMars;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int weightEarth=sc.nextInt();
        double weightMars = getWeight(weightEarth);
        // System.out.printf("%.2f",weightMars); с примением метода printf
        System.out.println(weightMars);


    }

}

