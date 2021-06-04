package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private ArrayList<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 o = new TaskA1();
        int count = 10 + random.nextInt(15);
        for (int i = 0; i < count; i++) {
            int grade = random.nextInt(10) + 1;
            o.grades.add(grade);
        }
        System.out.println(o.grades);
        o.clearBad(o.grades);
        System.out.println(o.grades);

    }

    void clearBad(List<Integer> grades) {
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
