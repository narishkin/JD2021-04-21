package by.it.nikitko.jd01_12;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    Integer[] arrayA = {2, -8, 6, 9, 47, 6, 8, 6, -6, 4, 55, 66, 3, 2};
    Double[] arrayB = {8.0, 6., -4.2, 3.3, 55.0, 46.0, -45.0, 55.0, 56.0, 4.0, 3.5, 3.0, 4.0, 5.0};
    Long[] arrayC = {8L, 6L, 7L, 3L, 4L, 500L};
    Set[] united = new Set[]{(Set) Arrays.asList(arrayA), (Set) Arrays.asList(arrayB), (Set) Arrays.asList(arrayC)};

    Set<Integer> intHashSet = new HashSet<>(Arrays.asList(arrayA));
    Set<Double> doubleHashSet = new HashSet<>(Arrays.asList(arrayB));
    Set<Long> longHashSet = new HashSet<>(Arrays.asList(arrayC));

    public static void main(String[] args) {
        TaskC2 taskC2 = new TaskC2();
        System.out.println("intHashSet     " + taskC2.intHashSet);
        System.out.println("doubleHashSet  " + taskC2.doubleHashSet);
        System.out.println("longHashSet    " + taskC2.longHashSet);
        System.out.println("getUnion       " + getUnion(taskC2.united));
        //   System.out.println("getCross " + getCross(taskC2.intHashSet, taskC2.doubleHashSet));
    }


    static <T> Set<String> getUnion(T[] in) {
        Set<String> result = new HashSet();
        for (int i = 0; i < in.length; i++) {
      result.addAll( Arrays.asList((in[i]).toString()));
        }

        return result;
    }


    static Set<Integer> getCross(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }

}
