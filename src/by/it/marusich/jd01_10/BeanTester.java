package by.it.marusich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        Object o = null;
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            if (method.isAnnotationPresent(Param.class)) {
                o = beanClass.newInstance();
                if (Modifier.isStatic(modifiers)) {
                    System.out.print(method.getName()+" ");
                    System.out.println(method.invoke(null, 3, 4));
                } else {
                    System.out.print(method.getName()+" ");
                    System.out.println(method.invoke(o, 3, 4));
                }
            }
        }

    }
}
