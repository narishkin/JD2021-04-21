package by.it.sapazhkou.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NullPointerException | NumberFormatException e) {
            Class<? extends RuntimeException> eClass = e.getClass();
            String name = eClass.getName();

            Class<TaskA> taskAClass = TaskA.class;
            StackTraceElement[] traceElements = e.getStackTrace();
            for (StackTraceElement traceElement : traceElements) {
                String className = taskAClass.getName();
                if(className.equals(taskAClass.getName())){
                    int lineN = traceElement.getLineNumber();
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
