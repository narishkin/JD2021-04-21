package by.it.nikitko.jd01_12;

import java.util.*;

public class TaskC2 {
    Integer[] arrayA = {2, -8, 6, 9, 5, 6, 8, 6, -6, 4, 55, 66, 3, 2};
    Double[] arrayB = {8.0, 6.0, -4.2, 3.3, 55.0, 46.0, -45.0, 5.0, 56.0, 4.0, 3.5, 3.0, 4.0, 5.0};
    Long[] arrayC = {8L, 6L, 7L, 3L, 4L, 500L};
   // Set[] united = new Set[]{(Set) Arrays.asList(arrayA), (Set) Arrays.asList(arrayB), (Set) Arrays.asList(arrayC)};

    Set<Integer> intHashSet = new HashSet<>(Arrays.asList(arrayA));
    Set<Double> doubleHashSet = new HashSet<>(Arrays.asList(arrayB));
    Set<Long> longHashSet = new HashSet<>(Arrays.asList(arrayC));

    public static void main(String[] args) {
        TaskC2 taskC2 = new TaskC2();
        System.out.println("intHashSet     " + taskC2.intHashSet);
        System.out.println("doubleHashSet  " + taskC2.doubleHashSet);
        System.out.println("longHashSet    " + taskC2.longHashSet);
        System.out.println("getUnion       " + getUnion(taskC2.intHashSet,taskC2.doubleHashSet,taskC2.longHashSet));
        System.out.println("getCross       " + getCross(taskC2.intHashSet,taskC2.doubleHashSet,taskC2.longHashSet));
    }


    static  Set<Double> getUnion(Set<?> ...setsArray) {
        Set<Double> result = new HashSet(setsArray[0]);
        for (int i = 1; i < setsArray.length; i++) {
            Iterator<?> iteratorSetsArray = setsArray[i].iterator();
            while (iteratorSetsArray.hasNext()) {
                Double currentNumber = Double.parseDouble(String.valueOf(iteratorSetsArray.next()));
                result.add(currentNumber);
            }
        }
        return result;
    }


    static  Set<Double> getCross(Set<?> ...setsArray) {
        Set<Double> result = new HashSet(setsArray[0]);
        for (int i = 1; i < setsArray.length; i++) {
            Iterator<?> iteratorResult = result.iterator();
            while (iteratorResult.hasNext()) {
                if (!setsArray[i].contains(iteratorResult.next())){
                    iteratorResult.remove();
                }
            }
        }
        return result;
    }
}
