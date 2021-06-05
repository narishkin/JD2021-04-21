package by.it.stain.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> math = Math.class;
        Method[] methods = math.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder stringMethod = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                stringMethod.append("public ");
            } else continue;
            if (Modifier.isStatic(modifiers)) {
                stringMethod.append("static ");
            }
            stringMethod.append(method.getReturnType().getSimpleName()).append(" ");

            stringMethod.append(method.getName());

            Class<?>[] parameterTypes = method.getParameterTypes();
            StringJoiner parameters = new StringJoiner(",", "(", ")");
            for (Class<?> parameterType : parameterTypes) {
                parameters.add(parameterType.toString());
            }
            stringMethod.append(parameters.toString());
            System.out.println(stringMethod);
        }
        Field[] fileds = math.getDeclaredFields();
        for (Field filed : fileds) {
            int modifiers = filed.getModifiers();
            StringBuilder stringField = new StringBuilder();
            if(Modifier.isPublic(modifiers)) {
                stringField.append("public ");
            }else continue;
            stringField.append(filed.getType()).append(" ");

            stringField.append(filed.getName());



            System.out.println(stringField);



        }




    }

}

