package by.it.nikitko.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class bean = Class.forName("by.it.nikitko.jd01_10.Bean");

        for (Method method : bean.getDeclaredMethods()) {
            String name = method.getName();
            Class<?>[] types = method.getParameterTypes();
            String returnType = method.getReturnType().getSimpleName();


            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                Object obj = bean.newInstance();
                System.out.println(method.invoke(obj,annotation.a(),  annotation.b()));
                System.out.printf("%s %s(%s)\n", returnType, name, Arrays.toString(types));
            }
        }
    }
}
/*
TaskC1. Создайте класс BeanTester с объявлением метода main, допускающего
Exception: public static void main(String[] args) throws Exception, который создает экземпляр класса Bean
из задания A (оператор new Bean( ) для этого использовать нельзя!), а затем находит и
запускает его методы, помеченные созданной аннотацией с указанными в ней параметрами a и b.
После каждого вызова invoke на консоль выводится имя найденного метода и результат запуска.
 */