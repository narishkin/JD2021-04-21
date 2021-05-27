package by.it.labovka.jd01_04;

import java.util.Scanner;

//формирует из строки line массив вещественных чисел,
    //    (можно скопировать для этого класс InOut, написанный в jd01_03 Задание A)
   //      выводит в 5 колонок этот массив с названием V и индексами (тоже InOut),
   //     например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
    //     сортирует этот массив по возрастанию (см. Helper.sort в jd01_03 Задание B)
     //    еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
     //    выполняет вычисление новых (после сортировки) индексов первого и последнего элемента
     //   исходного массива и печатает их в виде:
     //   Index of first element=2
     //   Index of last element=7
public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        buildOneDimArray(s);
    }
    static void printMulTable()
    {
        for (int i = 2; i <=9; i++) {
            for (int j = 2; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ", i,j,i*j);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line)
    {
double[] massiv = InOut.getArray(line);
double first = massiv[0];
double last = massiv[massiv.length-1];
InOut.printArray(massiv, "V", 5);
Helper.sort(massiv);
      InOut.printArray(massiv, "V",4 );
        for (int i = 0; i < massiv.length; i++) {
            if(massiv[i]==first) System.out.println("Index of first element="+i);
            else if (massiv[i]==last) System.out.println("Index of last element="+i);
        }

    }
}
