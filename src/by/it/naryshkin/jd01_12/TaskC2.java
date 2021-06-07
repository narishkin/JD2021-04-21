package by.it.naryshkin.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {

        Set<Long> a = new HashSet<>(Arrays.asList(16L, 2L, 3L, 9L, 4L, -5L, 5L, 6L));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 3, 5, 6, 7, 8, 16, -5, 0));
        Set<Double> c = new HashSet<>(Arrays.asList(0., 16., 2., 3., 4., -5., 8.));
        Set<Double> d = new HashSet<>(Arrays.asList(2., 16., 3., 4., 9., -5.));
        System.out.println(getUnion(c, b, a, d));
        System.out.println(getCross(c, b, a, d));

    }

    static Set<Number> getCross(Set<? extends Number>... sets) {
        Set<Number> result = new HashSet<>();
        for (int i = 0; i < sets.length; i++) {
            for (Number checkedElement : sets[i]) {
                int counter = 0;
                for (int j = 0; j < sets.length; j++) {
                    for (Number movingPointer : sets[j]) {
                        if (movingPointer.doubleValue() == checkedElement.doubleValue()) {
                            counter++;
                        }
                    }
                }
                if (counter == sets.length) {
                    if (result.size() == 0) {
                        result.add(checkedElement);
                    } else {
                        int c = 0;
                        for (Number number : result) {
                            if (number.doubleValue() != checkedElement.doubleValue()) {
                                c++;
                            }
                        }
                        if (c == result.size()) {
                            result.add(checkedElement);
                        }
                    }
                }
            }
        }
        return result;
    }

    static Set<Number> getUnion(Set<? extends Number>... sets) {
        Set<Number> result = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            for (Number numberAdd : sets[i]) {
                int counter = 0;
                for (Number elementResult : result) {
                    if (elementResult.doubleValue() != numberAdd.doubleValue()) {
                        counter++;
                    } else continue;
                    if (counter == result.size()) result.add(numberAdd);
                }
            }
        }

        return result;
    }


}
