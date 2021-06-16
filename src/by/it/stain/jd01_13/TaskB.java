package by.it.stain.jd01_13;

import java.util.Scanner;

public class TaskB{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        double sum = 0;
        double value;
        double sqrt;
        try {
            while (!(s = scanner.next()).equals("END")) {
                value = Double.parseDouble(s);
                sum+=value;
                sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException();
                }
                System.out.println(sqrt);
            }
        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    String nameExeption = e.getClass().getName();
                    String className = element.getClassName();
                    int numberLineExeption = element.getLineNumber();
                    System.out.printf("name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d",
                            nameExeption,
                            className,
                            numberLineExeption);
                    break;


                }


            }

        }
    }
}

