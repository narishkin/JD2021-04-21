package by.it.nikitko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TaskA1 {

    private final List<Integer> grades = new ArrayList<>();

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
        grades.removeIf(integer -> integer < 4);
    }
}



