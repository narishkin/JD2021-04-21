package by.it.mogonov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    private static final String[] PERSON_ARRAY = new String[]{"1", "2", "3", "4", "5"};
    static List<String> peoples = Arrays.asList(PERSON_ARRAY);


    public static void main(String[] args) {
        ArrayList<String> peoplesOne = new ArrayList<>(peoples);
        LinkedList<String> peoplesTwo = new LinkedList<>(peoples);
        System.out.println("peoplesOne= " + peoplesOne);
        System.out.println("peoplesTwo= " + peoplesTwo);
        System.out.println(process(peoplesOne));
        System.out.println(process(peoplesTwo));

    }

    static String process(ArrayList<String> peoples) {

        while (peoples.size() > 1) {
            for (int i = 0; i < peoples.size(); i++) {

                if (i % 2 != 0) {
                    peoples.remove(i);
                }

            }


        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {


        while (peoples.size() > 1) {
            for (int i = 0; i < peoples.size(); i++) {

                if (i % 2 != 0) {
                    peoples.remove(i);
                }

            }

        }
        return peoples.get(0);
    }
}
