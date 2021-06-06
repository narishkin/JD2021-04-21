package by.it.nikitko.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        try {
        while (true) {
            String inputString = scanner.nextLine();
            if (inputString.equals("END")) {
                break;
            }
            double currentDouble = Double.parseDouble(inputString);
            sum = currentDouble + sum;
            if (sum<0){throw new ArithmeticException();}
            System.out.println( Math.sqrt(sum));
            System.out.println(currentDouble);
        }

        } catch (NumberFormatException|ArithmeticException e) {
            Class<TaskB> taskBClass = TaskB.class;
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().equals(taskBClass.getName())) {
                    System.out.println("name:  "+e);
                    System.out.println("Class: "+stackTraceElement.getClassName());
                    System.out.println("line:  "+stackTraceElement.getLineNumber());
                }
            }
        }
    }
}
