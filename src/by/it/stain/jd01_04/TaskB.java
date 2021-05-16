package by.it.stain.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество человек: ");
        int people = scanner.nextInt();
        String[] array = new String[people];
        System.out.println("Введите " + people + " фамилий:");
        for (int i = 0; i < people; i++) {
            array[i] = scanner.next();
        }

        for (int i = 0; i < people; i++) {
            System.out.println(array[i]);

        }
        int[][] salary = new int[people][4];
        for (int i = 0; i < people; i++) {
            System.out.println("Введите зарплату " + array[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();

            }


        }
        int[] sumOfSalary = new int[people];
        for (int i = 0; i < people; i++) {
            for (int j = 0; j < 4; j++) {
                sumOfSalary[i] = salary[i][j] + sumOfSalary[i];


            }


        }


        String[] table = {"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};
        System.out.println(table[0] + " " + table[1] + " " + table[2] + " " + table[3] + " " + table[4] + " " + table[5]);

        for (int i = 0; i < people; i++) {
            System.out.print(array[i] + " ");
            for (int j = 0; j < 4; j++) {
                System.out.print(salary[i][j] + " ");

            }
            System.out.println(+sumOfSalary[i]);

        }
        int totalSumOfSalary = 0;
        for (int i = 0; i < sumOfSalary.length; i++) {
            totalSumOfSalary = totalSumOfSalary + sumOfSalary[i];

        }
        System.out.println(totalSumOfSalary + " - Общая зарплата");

        double averageSalary = totalSumOfSalary * 1.0 / (4 * people);


        System.out.println(averageSalary);


    }
}
