package by.it.zhurauleu.jd01_13;

import java.util.HashMap;

@SuppressWarnings("ConstantConditions")
public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            System.out.printf("name: %s\n", e.getClass().getName());
            Class<TaskA> taskAClass = TaskA.class;
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (taskAClass.getName().equals(stackTraceElement.getClassName())) {
                    System.out.printf("class: %s\n", stackTraceElement.getClassName());
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf("line: %s\n", lineNumber);
                    break;
                }
            }
        }
    }
}