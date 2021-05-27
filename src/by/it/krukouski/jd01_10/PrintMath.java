package by.it.krukouski.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;

        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            StringBuilder string = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                string.append("public ");
            }
            if (Modifier.isStatic(modifiers)){
                string.append("static ");
            }
            string.append(method.getReturnType()).append(" ");
            string.append(method.getName());

            System.out.println(string);


        }



    }
}
