package by.it.naryshkin.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        Class<?> BeanClass = Bean.class;

        Method[] m = BeanClass.getDeclaredMethods();

        for (Method method : m) {
            if (method.isAnnotationPresent(Param.class)) {
                System.out.println(method.getName());

                Bean b = new Bean();
                System.out.println(method.invoke(b, 2, 5));

            }
        }


    }
}
