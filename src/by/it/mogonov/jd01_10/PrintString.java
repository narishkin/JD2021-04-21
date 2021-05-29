package by.it.mogonov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {

        Class<String> arhString = String.class;
        Method[] methods = arhString.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();


            if (Modifier.isStatic(modifiers)) {
                continue;
            }

            System.out.println(method.getName());


        }
    }

}





