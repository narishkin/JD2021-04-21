package by.it._classwork_.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureMath = Math.class;
        Method[] methods = structureMath.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder methodString = new StringBuilder();

            if (Modifier.isPublic(modifiers)) {
                methodString.append("public ");
            } else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                methodString.append("static ");
            }

            methodString.append(method.getReturnType().getSimpleName());
            methodString.append(method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringJoiner parameters = new StringJoiner(", ", "(", ")");
            for (Class<?> parameterType : parameterTypes) {
                parameters.add(parameterType.toString());
            }
            methodString.append(parameters.toString());
            System.out.println(methodString);
        }
    }
}
