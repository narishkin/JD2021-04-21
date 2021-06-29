package by.it.marusich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (Exception e) {

            StackTraceElement[] traceElements = e.getStackTrace();
            for (StackTraceElement traceElement : traceElements) {
                if (TaskA.class.getName().equals(traceElement.getClassName())) {
                    String name = e.getClass().getName();
                    String className = traceElement.getClassName();
                    int rowNumber = traceElement.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %d", name, className, rowNumber);
                    break;
                }
            }
        }
    }
}