package by.it._classwork_.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> i = new HashSet<>(Arrays.asList(null, 1, 2, 3, 4, 4, 4, 5, 5, 6, 6));
        Set<Double> d = new HashSet<>(Arrays.asList(null, 1., 2., 3., 4., 9.));
        Set<Long> l = new HashSet<>(Arrays.asList(1L, 2L, 6L, 6L, Long.MAX_VALUE));
        Set<Float> f = new HashSet<>(Arrays.asList(1.f, 2.f, 3.f, 4.f));

        Set<Number> union = getUnion(i, d, l, f);
        System.out.printf("union=%s\n", union);
        Set<Number> cross = getCross(i, d, l, f);
        System.out.printf("cross=%s\n", cross);
    }

    @SafeVarargs
    private static Set<Number> getUnion(Set<? extends Number>... sets) {
        Set<Number> returnSet = new TreeSet<>(COMPARATOR);
        for (Set<? extends Number> set : sets) {
            returnSet.addAll(set);
        }
        return returnSet;
    }

    @SafeVarargs
    private static Set<Number> getCross(Set<? extends Number>... sets) {
        Set<Number> returnSet = new HashSet<>(sets[0]);
        returnSet.removeIf(o -> checkDeletion(o, sets));
        return returnSet;
    }

    private static boolean checkDeletion(Number value, Set<? extends Number>[] sets) {
        int count = 0;
        for (Set<? extends Number> set : sets) {
            for (Number number : set) {
                if (COMPARATOR.compare(number, value) == 0) {
                    count++;
                    break;
                }
            }
        }
        return count < sets.length;
    }


    private static final Comparator<Number> COMPARATOR =

            (o1, o2) -> {
                if (Objects.equals(o1,o2)) return 0;
                if (o1==null) return -1;
                if (o2==null) return 1;

                return o1.longValue() < o2.longValue() || o1.doubleValue() < o2.doubleValue()
                        ? -1
                        : o1.longValue() > o2.longValue() || o1.doubleValue() > o2.doubleValue()
                        ? 1
                        : 0;
            };
}
