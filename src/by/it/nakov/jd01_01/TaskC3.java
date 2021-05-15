package by.it.nakov.jd01_01;

import java.util.Locale;
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

    private static final double Grav_Mars = 3.86;
    private static final double Grav_Earth = 9.81;

    public static void main(String[] args) {

//        System.out.println("Ввод: ");
        final Scanner sc = new Scanner(System.in);
        final int weight = sc.nextInt();
        Locale.setDefault(Locale.ENGLISH);

        System.out.format("%.2f\n", getWeight(weight));
    }

    public static double getWeight(final int weight) {
        double v = weight * Grav_Mars / Grav_Earth;

        return Math.round(v * 100) / 100.0;
    }

}
