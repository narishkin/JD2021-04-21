package by.it.nikitko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class PrintString {
    public static void main(String[] args) {


        Class<String> structureString = String.class;
        Method[] arrMethodsString = structureString.getDeclaredMethods();

        for (Method method : arrMethodsString) {
            StringBuilder methodString = new StringBuilder();
            if (!Modifier.isStatic(method.getModifiers())) {
                methodString.append(method.getName());
                System.out.println(methodString);
            }
        }
    }
}


