package by.it.krukouski.jd01_13;

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
            String nameE = eClass.getName();

            Class<TaskA> taskAClass = TaskA.class;
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String stackTraceElementClassName = stackTraceElement.getClassName();
                if (stackTraceElementClassName.equals(taskAClass.getName())) {
                    int line = stackTraceElement.getLineNumber();
                    System.out.printf("name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d",
                            nameE, stackTraceElementClassName, line);

                }

            }
        }
    }
}
