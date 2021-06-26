package by.it.marusich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private final List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 o = new TaskA1();
        int count = 5 + random.nextInt(10);
        for (int i = 0; i < count; i++) {
            int grade = 1 + random.nextInt(10);
            o.grades.add(grade);
        }
        System.out.println(o.grades);
        o.clearBad(o.grades);
        System.out.println(o.grades);

    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        //noinspection Java8CollectionRemoveIf
        while (iterator.hasNext()) {
            Integer currentGrade = iterator.next();
            if (currentGrade < 4) {
                iterator.remove();
            }
        }
    }

}
