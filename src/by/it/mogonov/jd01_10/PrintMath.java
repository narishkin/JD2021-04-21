package by.it.mogonov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> arhMath = Math.class;
        Method[] methods = arhMath.getDeclaredMethods();
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

            methodString.append(method.getReturnType().getTypeName()).append(" ");
            methodString.append(method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringJoiner parameters = new StringJoiner(",", "(", ")");
            for (Class<?> parameterType : parameterTypes) {
                parameters.add(parameterType.toString());
            }
            methodString.append(parameters);
            System.out.println(methodString);
            printFields(arhMath);

        }
    }

    private static void printFields(Class <?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            StringBuilder fieldString = new StringBuilder();
            if (Modifier.isFinal(modifiers)) {
                String s = "final ";
                fieldString.append(s);

            }
            if (Modifier.isPublic(modifiers)) {
                fieldString.append("public ");
            } else {
                continue;
            }
            if (Modifier.isStatic(modifiers)) {
                fieldString.append("static ");

            }

            fieldString.append(field.getType().getTypeName()).append(" ");
            fieldString.append(field.getName());
            StringJoiner parameters = new StringJoiner(",", "(", ")");
            fieldString.append(parameters);
            System.out.println(fieldString);
        }
    }

}


