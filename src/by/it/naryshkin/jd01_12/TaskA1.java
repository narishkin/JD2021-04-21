package by.it.naryshkin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        Random random = new Random();

        for (int i=0;i<20;i++) {
            taskA1.list.add(random.nextInt(10)+1);
        }
        System.out.println("Исходный массив:");
        System.out.println(taskA1.list);

        taskA1.clearBad(taskA1.list);
        System.out.println("Обработанный массив:");
        System.out.println(taskA1.list);

    }

    void clearBad(List<Integer> grades){
        Iterator<Integer> it = grades.iterator();
        while (it.hasNext()){
            if (it.next()<=3){
                it.remove();
            }
        }
//        grades.removeIf(i ->(i<=3));
    }

}
