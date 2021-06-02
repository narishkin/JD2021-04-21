package by.it.sapazhkou.jd01_10;

import java.lang.reflect.*;
import java.util.StringJoiner;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> structureMath = Math.class;

        Field[] fields = structureMath.getFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder sb = new StringBuilder();
                sb.append(Modifier.toString(field.getModifiers()) + " ");
                sb.append(field.getType().toString() + " ");
                sb.append(field.getName());
                System.out.println(sb);
            }
        }

        Method[] declaredMethods = structureMath.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if ((declaredMethod.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder sb = new StringBuilder();
                sb.append(Modifier.toString(declaredMethod.getModifiers()) + " ");
                sb.append(declaredMethod.getReturnType().getSimpleName() + " ");
                sb.append(declaredMethod.getName());
                StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
                Class<?>[] parameters = declaredMethod.getParameterTypes();
                for (Class<?> parameter : parameters) {
                    stringJoiner.add(parameter.toString());
                }
                sb.append(stringJoiner.toString());
                System.out.println(sb);
            }
        }

    }

}
