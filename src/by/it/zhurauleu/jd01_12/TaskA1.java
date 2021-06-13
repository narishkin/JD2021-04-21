package by.it.zhurauleu.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private ArrayList<Integer> grades;

    TaskA1() {
        grades = new ArrayList<>();
    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 someClass = new TaskA1();
        Random random = new Random();
        int numberOfStudents = 30;
        for (int i = 0; i < numberOfStudents; i++) {
            someClass.grades.add(random.nextInt(10) + 1);
        }
        System.out.println(someClass.grades);
        someClass.clearBad(someClass.grades);
        System.out.println(someClass.grades);
    }
}