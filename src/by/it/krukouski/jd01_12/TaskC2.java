package by.it.krukouski.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Set<Number> resultSet = new HashSet<>(hashSet[0]);
        for (int i = 1; i < hashSet.length; i++) {
            int count = 0;
            for (Number numberHashSet : hashSet[i]) {
                for (Number numberResultSet : resultSet) {
                    if (numberHashSet.doubleValue() != numberResultSet.doubleValue()) {
                        count++;
                    }
                    if (count == resultSet.size()) {
                        resultSet.add(numberHashSet);
                    }
                }

            }

        }
        return resultSet;
    }

    private static Set<Number> getCross(Set<?>... hashSet) {
        Set<Number> resultSet = new HashSet<>();
        for (Set<?> collection : hashSet) {
            resultSet.retainAll(collection);
        }
        return resultSet;
    }

}
