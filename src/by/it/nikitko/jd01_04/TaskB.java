package by.it.nikitko.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of people");
        int numberOfPeople = scanner.nextInt();

        String[] lastNames = new String[numberOfPeople];
        System.out.println("Input last names");

        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scanner.next();
        }
        scanner.nextLine();   // Нужны пояснения

        int[][] salary = new int[numberOfPeople][4];

        // input salary
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Input salary for " + lastNames[i]);
            String line = scanner.nextLine();
            System.arraycopy(InOut.getIntArray(line), 0, salary[i], 0, salary[0].length);
        }

        System.out.println("________________________________________________________________");
        System.out.println("Фамилия   Квартал 1   Квартал 2   Квартал 3   Квартал 4   Итого ");
        System.out.println("________________________________________________________________");

        float totalSalary = 0;
        for (int i = 0; i < salary.length; i++) {
            int yearSalary = 0;
            System.out.printf("%-10s", lastNames[i]);
            for (int j = 0; j < salary[0].length; j++) {
                System.out.printf("%-12d", salary[i][j]);
                yearSalary = yearSalary + salary[i][j];
                if ((j + 1) % (salary[0].length + 1) == 0 || (j + 1) == salary[0].length) {
                    System.out.printf("%-12d", yearSalary);
                    totalSalary = totalSalary + yearSalary;
                    System.out.println();
                }
            }
        }
        System.out.println("________________________________________________________________");
        System.out.println("Итого     " + totalSalary);
        System.out.printf("Средняя   %.5f", totalSalary / 4 / numberOfPeople);
    }
}
