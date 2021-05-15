package by.it.sapazhkou.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        int periodCount = 4;
        Scanner scanner = new Scanner(System.in);
        int personCount = scanner.nextInt();
        int[][] payrollArray = new int[personCount][periodCount];
        String[] personNameArray = new String[personCount];
        for (int i = 0; i < personNameArray.length; i++) {
            personNameArray[i] = scanner.next();
        }
        for (int i = 0; i < payrollArray.length; i++) {
            System.out.println("Введите зарплату для "+personNameArray[i]);
            for (int j = 0; j < payrollArray[i].length; j++) {
                payrollArray[i][j] = scanner.nextInt();
            }
        }
        System.out.println("-------------------------------------------------------"+"\n"+
                           "Фамилия   Квартал1  Квартал2  Квартал3  Квартал4  Итого"+"\n"+
                           "-------------------------------------------------------");
        int sumTotal =0;

        for (int i = 0; i < payrollArray.length; i++) {
            int sumPerson = 0;
            System.out.printf("%8s: ",personNameArray[i]);
            for (int j = 0; j < payrollArray[i].length; j++) {
                sumPerson = sumPerson + payrollArray[i][j];
                System.out.printf("%-10d",payrollArray[i][j]);
            }
            System.out.printf("%-5d%n",sumPerson);
            sumTotal = sumTotal + sumPerson;
        }
        double sumTotalDouble = sumTotal;
        double averageValue = sumTotalDouble/(periodCount*personCount);
        System.out.println("-------------------------------------------------------");
        System.out.printf("Итого     %-10d%n"+
                          "Средняя   %,10.7f",sumTotal,averageValue);
    }


}
