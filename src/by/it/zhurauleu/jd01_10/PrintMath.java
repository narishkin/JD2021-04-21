package by.it.zhurauleu.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            StringBuilder line = new StringBuilder();
            int modifiers = declaredMethod.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                line.append("public ");
            }
            else continue;
            if (Modifier.isStatic(modifiers)) {
                line.append("static ");
            }
            String returnType = declaredMethod.getReturnType().getSimpleName();
            line.append(returnType);
            line.append(" ");
            line.append(declaredMethod.getName());
            System.out.println(line);
            StringJoiner joiner = new StringJoiner(",", "(", ")");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                joiner.add(parameterType.getSimpleName());
            }
            line.append(joiner);
            System.out.println(line);
        }
        Field[] declaredFields = mathClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            StringBuilder line = new StringBuilder();
            int modifiers = declaredField.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                line.append("public ");
            }
            else continue;
            if (Modifier.isStatic(modifiers)) {
                line.append("static ");
            }
            String typeName = declaredField.getType().getSimpleName();
            line.append(typeName);
            line.append(" ");
            line.append(declaredField.getName());
            System.out.println(line);

        }

    }
}
