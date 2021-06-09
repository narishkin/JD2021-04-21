package by.it.sapazhkou.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class BeanTester {

    public static void main(String[] args) throws Exception {

        Class<?> bean = Bean.class;
        Class<? extends Annotation> anno = Param.class;
        Method a = anno.getMethod("a");
        Method b = anno.getMethod("b");


        Constructor<?>[] constructors = bean.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];

        Object newBean = constructor.newInstance();

        Method[] methods = bean.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(anno)) {

                Annotation annotation = method.getAnnotation(anno);
                int aValue = (int) a.invoke(annotation);
                int bValue = (int) b.invoke(annotation);
                System.out.println(method.getName() + " " + method.invoke(newBean, aValue, bValue));
            }
        }
    }
}
