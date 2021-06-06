package by.it.nikitko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }

        catch (NullPointerException|NumberFormatException e){
            Class<TaskA> taskAClass = TaskA.class;
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().equals(taskAClass.getName())) {
                    System.out.println("name:  "+e);
                    System.out.println("Class: "+stackTraceElement.getClassName());
                    System.out.println("line:  "+stackTraceElement.getLineNumber());
                }
            }
        }
    }
}
