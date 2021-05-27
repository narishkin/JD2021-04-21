package by.it.nikitko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureMath = Math.class;
        Method[] methodsMath = structureMath.getDeclaredMethods();

        for (Method method : methodsMath) {
            StringBuilder methodString = new StringBuilder();
            if (Modifier.isPublic(method.getModifiers()))
                methodString.append("Public ");
            if (Modifier.isStatic(method.getModifiers()))
                methodString.append("Static ");


            methodString.append(method.getReturnType().getSimpleName()).append(" ");
            methodString.append(method.getName()).append(" ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringJoiner parameters = new StringJoiner(", ", "(", ")");
            for (Class<?> parameterType : parameterTypes) {
                parameters.add(parameterType.toString());
            }
            methodString.append(parameters.toString());
            System.out.println(methodString);

//public static float abs(float)
        }
    }
}
