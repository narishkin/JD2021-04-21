package by.it.naryshkin.jd01_01;

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
    static final float GRAVITY_MARS = 3.86f;
    static final float GRAVITY_EARTH = 9.81f;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int inputMass = sc.nextInt();
        System.out.println(TaskC3.getWeight(inputMass));


    }

    static double getWeight(int weightEarth) {


        int weightMars = (int) (weightEarth * (GRAVITY_MARS / GRAVITY_EARTH) * 1000);

        if (weightMars % 10 < 5) return (double) (weightMars / 10) / 100;
        else return (double) (weightMars / 10 + 1) / 100;

    }

}
