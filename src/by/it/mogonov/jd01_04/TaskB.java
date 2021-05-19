package by.it.mogonov.jd01_04;

import java.util.Scanner;

public class TaskB {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int n = sc.nextInt();
        String[] surnames = new String[n];
        for (int i = 0; i < n; i++) {
            surnames[i] = sc.next();
        }
        String[][] body = new String[n][6];
        int totalSum = 0;
        for (int i = 0; i < surnames.length; i++) {
            body[i][0] = surnames[i] + ":";
            System.out.println("Введите зарплату для " + surnames[i] + ":");
            String[] salaries = sc.next().split(" ");
            int total = 0;
            for (int j = 0; j < salaries.length; j++) {
                body[i][j + 1] = salaries[j];
                total += Integer.parseInt(salaries[j]);
            }
            totalSum += total;
            body[i][body[i].length - 1] = String.valueOf(total);

        }


        String[] headers = {"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};
        String line = "-".repeat(55);
        System.out.println(line);
        for (String header : headers) {
            System.out.printf("%-10s", header);
        }
        System.out.println();
        System.out.println(line);
        for (String[] strings : body) {
            for (String string : strings) {
                System.out.printf("%-10s", string);
            }
            System.out.println();
        }
        System.out.println(line);
        System.out.printf("Итого %-10s%d\n", "", totalSum);
        System.out.printf("Средняя %-10s%.4f\n", "", (double) totalSum / n/4);

    }
}