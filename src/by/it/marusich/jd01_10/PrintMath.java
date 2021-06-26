package by.it.marusich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;

        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            StringBuilder stringMethod = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                stringMethod.append("public ");
            } else continue;
            if (Modifier.isStatic(modifiers)) {
                stringMethod.append("static ");
            }
            stringMethod.append(method.getReturnType()).append(" ");
            stringMethod.append(method.getName());

            Class<?>[] parameterTypes = method.getParameterTypes();
            StringJoiner parameterString = new StringJoiner(",", "(", ")");
            for (Class<?> parameterType : parameterTypes) {
                parameterString.add(parameterType.toString());
            }
            stringMethod.append(parameterString.toString());
            System.out.println(stringMethod);
        }
        Field[] declaredFields = mathClass.getDeclaredFields();
        for (Field field : declaredFields) {
            int modifier = field.getModifiers();
            StringBuilder stringField = new StringBuilder();
            if (Modifier.isPublic(modifier)) {
                stringField.append("public ");
            } else continue;
            if (Modifier.isStatic(modifier)) {
                stringField.append("static ");
            }
            stringField.append(field.getType()).append(" ");
            stringField.append(field.getName());
            System.out.println(stringField);

        }
    }
}

