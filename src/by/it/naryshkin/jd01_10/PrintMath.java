package by.it.naryshkin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> MathClass = Math.class;
//        Class MathClass = Class.forName("java.lang.Math");
        Field[] constants = MathClass.getDeclaredFields();
        for (Field constant : constants) {
            int modifiers = constant.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                System.out.println(constant.getGenericType() + " " + constant.getName());
            }

        }
        Method[] methods = MathClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder sb = new StringBuilder();
            if (Modifier.isPublic(modifiers)) sb.append("public ");
            else continue;
            if (Modifier.isStatic(modifiers)) sb.append("static ");
            sb.append(method.getReturnType() + " ");
            sb.append(method.getName() + "(");
            Class<?>[] parType = method.getParameterTypes();
            if (parType.length > 0) {
                for (Class param : parType) {
                    sb.append(param.toString() + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
    }
}
