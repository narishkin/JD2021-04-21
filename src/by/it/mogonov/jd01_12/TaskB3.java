package by.it.mogonov.jd01_12;

import java.util.*;

public class TaskB3 {

    private static final String[] PERSON_ARRAY = new String[]{"1", "2", "3", "4", "5"};
    static List<String> peoples = Arrays.asList(PERSON_ARRAY);


    public static void main(String[] args) {

        ArrayList<String> peoplesOne = new ArrayList<>(peoples);
        LinkedList<String> peoplesTwo = new LinkedList<>(peoples);
        int[] test=new int[4096];
        int n=test.length;

        for (int i = 0; i <=n ; i++) {
            peoplesOne.add("n"+i);
            peoplesTwo.add("i"+i);


        }
        System.out.println("peoplesOne= " + peoplesOne);
        System.out.println("peoplesTwo= " + peoplesTwo);
        System.out.println(process(peoplesOne));
        System.out.println(process(peoplesTwo));

    }

    static String process(ArrayList<String> peoples) {
        boolean isSecond = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (isSecond) {
                    iterator.remove();
                }
                isSecond = !isSecond;
            }

        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {

        boolean isSecond = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (isSecond) {
                    iterator.remove();
                }
                isSecond = !isSecond;
            }
        }
        return peoples.getFirst();
    }

}
