package by.it.krukouski.jd01_12;

import java.util.*;

public class TaskC2 {
    private static final Integer[] i = {1, 2, 3, 4, 5};
    private static final Double[] d = {10.0, 20.0, 30.0, 40.0, 50.0, 60.0};
    private static final Long[] l = {1L, 2L, 3L, 4L, 5L, 6L};


    public static void main(String[] args) {
        Set<Integer> hashSetInteger = new HashSet<>(Arrays.asList(i));
        Set<Double> hashSetDouble = new HashSet<>(Arrays.asList(d));
        Set<Long> hashSetLong = new HashSet<>(Arrays.asList(l));
        System.out.println(getUnion(hashSetInteger, hashSetDouble, hashSetLong));
        System.out.println(getCross(hashSetInteger, hashSetDouble, hashSetLong));


    }

    private static Set<Number> getUnion(Set<? extends Number>... hashSet) {
        Set<Number> resultSet = new TreeSet<>(COMPARATOR);
        for (Set<? extends Number> set : hashSet) {
            resultSet.addAll(set);
        }
        return resultSet;

    }

    private static Set<Number> getCross(Set<? extends Number>... hashSet) {
        Set<Number> resultSet = new HashSet<>(hashSet[0]);
        resultSet.removeIf(o -> checkValue(o, hashSet));
        return resultSet;

    }

    private static boolean checkValue(Number o, Set<? extends Number>[] hashSet) {
        int count = 0;
        for (Set<? extends Number> numbers : hashSet) {
            for (Number number : numbers) {
                if (COMPARATOR.compare(number, o)==0){
                    count++;
                    break;
                }

            }

        }
        return count < hashSet.length;

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


