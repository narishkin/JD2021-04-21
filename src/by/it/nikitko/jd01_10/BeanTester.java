package by.it.nikitko.jd01_10;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("by.it.nikitko.jd01_10.Bean");
        //далее я не знаю что это за класс, но могу получить его методы
        for (Method method : c.getDeclaredMethods()) {
            String name = method.getName();
            Class<?>[] types = method.getParameterTypes();
            String returnType = method.getReturnType().getSimpleName();
            System.out.printf("%s %s(%s)\n", returnType, name, Arrays.toString(types));
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