package by.it.nikitko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        Random randomGrades = new Random();
        for (int i = 0; i < 25; i++) {
            task.grades.add(randomGrades.nextInt(10) + 1);
        }

        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }


    void clearBad(List<Integer> grades) {
        Iterator<Integer> iteratorGrades = grades.iterator();
        while (iteratorGrades.hasNext()) {
            if (iteratorGrades.next() < 4) {
                iteratorGrades.remove();
            }
        }
    }
}
