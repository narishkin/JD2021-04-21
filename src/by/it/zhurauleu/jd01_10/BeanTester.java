package by.it.zhurauleu.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> beanConstructor = beanClass.getConstructor();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        Object o = beanConstructor.newInstance();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)) {
                Method[] annoDeclaredMethods = Param.class.getDeclaredMethods();
                int[] params = new int[annoDeclaredMethods.length];
                for (int i = 0; i < annoDeclaredMethods.length; i++) {
                    params[i] = (int) annoDeclaredMethods[i].invoke(declaredMethod.getDeclaredAnnotation(Param.class));
                }
                System.out.print(declaredMethod.getName() + " ");
                System.out.println(declaredMethod.invoke(o, params[0], params[1]));
            }
        }
    }
}


