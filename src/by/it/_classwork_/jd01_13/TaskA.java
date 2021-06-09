package by.it._classwork_.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            Class<? extends RuntimeException> eClass = e.getClass();
            String name = eClass.getName();


            Class<TaskA> mainClass = TaskA.class;
            StackTraceElement[] traceElements = e.getStackTrace();
            for (StackTraceElement traceElement : traceElements) {
                String className = traceElement.getClassName();
                if (className.equals(mainClass.getName())) {
                    int lineNumber = traceElement.getLineNumber();
                    System.out.printf("" +
                                    " name: %s\n" +
                                    "class: %s\n" +
                                    " line: %d\n"
                            , name, className, lineNumber);
                    break;
                }
            }
        }
    }
}
