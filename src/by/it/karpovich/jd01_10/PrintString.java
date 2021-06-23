package by.it.karpovich.jd01_10;

import java.lang.reflect.Method;
import static java.lang.reflect.Modifier.isStatic;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (!(isStatic(method.getModifiers()))) {
                System.out.println(method.getName());
            }
        }
    }
}
