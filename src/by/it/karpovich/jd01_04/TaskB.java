package by.it.karpovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfMembers = scan.nextInt();
        String[] members = new String[countOfMembers];
        int[][] salary = new int[countOfMembers][4];
        int[] sumForEachOther = new int[countOfMembers];

        for (int i = 0; i < countOfMembers; i++) {
            members[i] = scan.next();
        }
        for (int i = 0; i < countOfMembers; i++) {
            System.out.println("Введите зарплату для " + members[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scan.nextInt();
                sumForEachOther[i] = sumForEachOther[i] + salary[i][j];
            }
        }

        int sumOfSalary = 0;
        for (int i = 0; i < sumForEachOther.length; i++) {
            sumOfSalary = sumOfSalary + sumForEachOther[i];
        }
        double averageQuarterSalary;
        double sumForAverageQuarterSalary = 0;
        for (int i = 0; i < countOfMembers; i++) {
            for (int j = 0; j < 4; j++) {
                sumForAverageQuarterSalary = sumForAverageQuarterSalary + salary[i][j];
            }
        }
        averageQuarterSalary = (sumForAverageQuarterSalary / (countOfMembers * 4));

        for (int i = 0; i < countOfMembers; i++) {
            System.out.println();
            System.out.printf("%-10s:", members[i] + " ");
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-3d",salary[i][j]);
            }
            System.out.printf("%-4d",sumForEachOther[i]);
        }
        System.out.println();
        System.out.printf("Итого     %-10d%n"+ "Средняя   %,10.7f",sumOfSalary,averageQuarterSalary);
    }

}
