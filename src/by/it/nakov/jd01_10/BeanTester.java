package by.it.nakov.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class clazz = Bean.class;
        Method[] method3 = clazz.getDeclaredMethods();
        for (Method method : method3) {
            Annotation[] annotation = method.getAnnotations();
            for (Annotation annotation1 : annotation) {
            for (int i = 0; i < method3.length; i++) {
                    if (method3[i].getName().startsWith("Param")) {
                        System.out.println(method3[i].invoke("a","b"));
                    }
                }
                System.out.println(Arrays.toString(annotation));
            }
        }
    }
}
