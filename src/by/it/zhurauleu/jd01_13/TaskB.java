package by.it.zhurauleu.jd01_13;

import java.util.Scanner;

@SuppressWarnings("InfiniteLoopStatement")
public class TaskB {

    static final String STOP_WORD = "END";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        for (; ; ) {
            String inputLine = input.nextLine();
            if (!STOP_WORD.equals(inputLine)) {
                try {
                    double inputVariable = Double.parseDouble(inputLine);
                    System.out.println("input variable = " + inputVariable);
                    sum += inputVariable;
                    System.out.println("sum = " + sum);
                    if (sum > 0) {
                        System.out.println("sum sqrt = " + Math.sqrt(sum));
                    } else {
                        ArithmeticException e = new ArithmeticException("square root of negative number");
                        printException(e);
                    }

                } catch (NumberFormatException e) {
                    printException(e);
                }
            }
        }
    }

    private static void printException(Exception e) {
        System.out.printf("name: %s\n", e.getClass().getName());
        Class<TaskB> taskBClass = TaskB.class;
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (taskBClass.getName().equals(stackTraceElement.getClassName())) {
                System.out.printf("class: %s\n", stackTraceElement.getClassName());
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("line: %s\n", lineNumber);
                break;
            }
        }
    }


}
