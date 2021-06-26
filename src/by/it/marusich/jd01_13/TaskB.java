package by.it.marusich.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    private static double sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String value = sc.next();
            if (value.equals("END")) {
                break;
            }

            try {
                double n = Double.parseDouble(value);
                if (n < 0) {
                    throw new ArithmeticException();
                }
                System.out.println("Current number: " + n);
                sum += n;
                double sqrt = Math.sqrt(sum);
                System.out.printf(Locale.ROOT, "sqrt: %f\n", sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                Class<? extends RuntimeException> eClass = e.getClass();
                String nameE = eClass.getName();

                Class<by.it.krukouski.jd01_13.TaskB> taskBClass = by.it.krukouski.jd01_13.TaskB.class;
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String stackTraceElementClassName = stackTraceElement.getClassName();
                    if (stackTraceElementClassName.equals(taskBClass.getName())) {
                        int line = stackTraceElement.getLineNumber();
                        System.out.printf("name: %s\n" +
                                        "class: %s\n" +
                                        "line: %d\n",
                                nameE, stackTraceElementClassName, line);

                    }

                }
            }

        }
    }
}