package by.it.nakov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();


        String[] lastName = new String[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            lastName[i] = scanner.next();
            int n = 0;
            int[][] salary = new int[n][4];
            for (int j = 0; j < numberOfPeople; j++) {
                System.out.println("Введите зарплату для " + lastName[i]);
                for (int l = 0; l < 4; j++) {

//                    salary[j] = new int[lastName.length];
                    salary[n][lastName.length] = scanner.nextInt();
                }
            }
        }
//            System.out.println(salary[k][4]);
//            }

//            Scanner sc = new Scanner(System.in);
//
//                BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
//                String x = null;

    }
//            System.out.println(salary[lastName.length][str.length]);
//
//        System.out.println("---------------------------------------------------------------------");
//                System.out.println("Фамилия     Квартал1     Квартал2     Квартал3     Квартал4     Итого");
//                System.out.println("---------------------------------------------------------------------");
//        for (int i = 0; i < numberOfPeople; i++) {
//            System.out.printf(s);
//        }

}


// Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
//итогом за год в последней колонке.

