package by.it.nikitko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureMath = Math.class;
        Method[] methodsMath = structureMath.getDeclaredMethods();
        // System.out.println( Arrays.deepToString(methodsMath));


        for (Method method : methodsMath) {
            boolean flagPublic = false;
            StringBuilder methodString = new StringBuilder();
            if (Modifier.isPublic(method.getModifiers())) {
                methodString.append("public ");
                flagPublic = true;
            }
            if (Modifier.isStatic(method.getModifiers()))
                methodString.append("static ");


            methodString.append(method.getReturnType().getSimpleName()).append(" ");
            methodString.append(method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringJoiner parameters = new StringJoiner(",", "(", ")");
            for (Class<?> parameterType : parameterTypes) {
                parameters.add(parameterType.toString());
            }
            methodString.append(parameters.toString());

            if (flagPublic) {
                System.out.println(methodString);
            }

        }


        Field[] constMath = structureMath.getDeclaredFields();
        for (Field cons : constMath) {
            StringBuilder constString = new StringBuilder();
            if (Modifier.isPublic(cons.getModifiers())) {

                constString.append(cons.getType()).append(" ");
                constString.append(cons.getName());
                System.out.println(constString);
            }
        }
    }
}
//public static float abs(float)
//public static long addexact(long,long)
//public static long addExact(long,long)
// public static double atan2(double,double)