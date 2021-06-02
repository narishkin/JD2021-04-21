package by.it._classwork_.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] array1 = {101, 2, 3, 4, 4, 5, 5, 6, 6, 7};
        Integer[] array2 = {40, 4, 5, 5, 6, 7, 99, 7, 8, 8};
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(array1));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(array2));
        System.out.printf("hashSet=%s\n", hashSet);
        System.out.printf("treeSet=%s\n", treeSet);
        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.printf("union=%s\n", union);
        Set<Integer> cross = getCross(hashSet, treeSet);
        System.out.printf("cross=%s\n", cross);
    }

    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> returnSet = new HashSet<>(left);
        returnSet.addAll(right);
        return returnSet;
    }

    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
        HashSet<Integer> returnSet = new HashSet<>(left);
        returnSet.retainAll(right);
        return returnSet;
    }
}
