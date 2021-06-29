package by.it.marusich.jd01_13;

import java.util.Scanner;

public class TaskB {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        double sum = 0;
        double value;
        double result;
        try {
            while (!(s = sc.next()).equals("END")) {
                value = Double.parseDouble(s);
                System.out.println(value);
                sum = sum + value;
                result = Math.sqrt(sum);
                if (Double.isNaN(result)) {
                    throw new ArithmeticException();
                }
                System.out.println(result);
            }
        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] STE = e.getStackTrace();
            for (StackTraceElement stackTraceElement : STE) {
                if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                    String name = e.getClass().getName();
                    String className = stackTraceElement.getClassName();
                    int rowNumber = stackTraceElement.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %d", name, className, rowNumber);
                    break;
                }
            }
        }
    }
}