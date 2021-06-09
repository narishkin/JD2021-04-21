package by.it.sapazhkou.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TaskA1 {

    List<Integer> grades = new ArrayList();

    private void clearBad(List<Integer> grades){
        Iterator <Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer iteratorValue = iterator.next();
            if(iteratorValue < 4){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 30; i++) {
            task.grades.add((int) Math.ceil(Math.random()*10));
        }
        System.out.println((task.grades).toString());
        task.clearBad(task.grades);
        System.out.println((task.grades).toString());

    }


}
