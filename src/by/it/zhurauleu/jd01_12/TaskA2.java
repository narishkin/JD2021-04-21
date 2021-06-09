package by.it.zhurauleu.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {

        Integer[] array1 = {1, 2, 3, 4, 5, 6};
        Integer[] array2 = {4, 5, 6, 7, 8, 9};
        Set<Integer> a = new HashSet<>(Arrays.asList(array1));
        Set<Integer> b = new TreeSet<>(Arrays.asList(array2));
        System.out.printf("HS: %s\n", a);
        System.out.printf("TS: %s\n", b);
        Set<Integer> crossResult = getCross(a, b);
        System.out.printf("cross: %s\n", crossResult);
        Set<Integer> unionResult = getUnion(a, b);
        System.out.printf("union: %s\n", unionResult);
    }

    private static Set<Integer> getCross(Set<Integer> first, Set<Integer> second) {
        HashSet<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> first, Set<Integer> second) {
        HashSet<Integer> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }
}
