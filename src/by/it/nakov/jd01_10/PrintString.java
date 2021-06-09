package by.it.nakov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[]method=stringClass.getClass().getDeclaredMethods();
        for (Method method1: stringClass.getDeclaredMethods()){
            if ((method1.getModifiers()& Modifier.STATIC)!=Modifier.STATIC){
                System.out.println(method1);
            }
        }
    }
}
