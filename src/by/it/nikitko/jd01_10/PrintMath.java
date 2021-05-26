package by.it.nikitko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureMath = Math.class;
        Method[] metodsMath = structureMath.getDeclaredMethods();
        StringBuilder methodString = new StringBuilder();
        for (Method method : metodsMath) {
            if (Modifier.isPublic(method.getModifiers()))
                methodString.append("Public");
            if (Modifier.isStatic(method.getModifiers()))
                methodString.append("Static");
            System.out.println(method);
        }
    }
}
