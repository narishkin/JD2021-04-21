package by.it.stain.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> string = String.class;
        Method[]methods=string.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder stringMethod = new StringBuilder();
            if(Modifier.isStatic(modifiers)){
                continue;
            }else {
                stringMethod.append(method.getName());

            }
            System.out.println(stringMethod);
        }

    }
}
