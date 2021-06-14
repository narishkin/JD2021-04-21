package by.it.nakov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else Integer.parseInt("Привет");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (TaskA.class.getName().equals(stackTraceElement.getClassName())) {
                    System.out.println(stackTraceElement);
                    String name = e.getClass().getName();
                    String clName = stackTraceElement.getClassName();
                    int number = stackTraceElement.getLineNumber();
                    System.out.printf(
                            " name: %s\n"+
                            "class: %s\n"+
                            " line: %d\n",
                            name,clName,number);
                    break;
                }
            }
        }
    }
}
