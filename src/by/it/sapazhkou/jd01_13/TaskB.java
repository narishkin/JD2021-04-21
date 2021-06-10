package by.it.sapazhkou.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Float.NaN;


public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> values = new ArrayList<>();
//        int position = 0;
        for (; ; ) {
            String next = scanner.next();
            if (next.equals("END")) {
                break;
            } else {
                values.add(next);
            }

        }
        double sum = 0.0;
        for (String value : values) {
            try {
                double number = Double.parseDouble(value);
                sum = sum + number;
                double result = Math.sqrt(sum);
                if (Double.isNaN(result)) {
                    throw new ArithmeticException();
                }
                System.out.print(number + " ");
                System.out.println(result);

            } catch (ArithmeticException | NumberFormatException e) {
                Class<? extends RuntimeException> eClass = e.getClass();
                String name = eClass.getName();

                Class<TaskB> taskClass = TaskB.class;
                StackTraceElement[] traceElements = e.getStackTrace();
                for (StackTraceElement traceElement : traceElements) {
                    String className = taskClass.getName();
                    if (className.equals(taskClass.getName())) {
                        int lineN = traceElement.getLineNumber();
                        System.out.println();
                        System.out.printf("" +
                                        " name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n"
                                , name, className, lineN);
                        break;
                    }
                }
            }
        }
    }
}
