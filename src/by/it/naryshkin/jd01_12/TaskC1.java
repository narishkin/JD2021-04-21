package by.it.naryshkin.jd01_12;

import java.util.*;

public class TaskC1 {
    static Map<Integer, Object> C = new TreeMap<>();
    String strObject;

    public static void main(String[] args) {
        String enter;
        TaskC1 taskC1;
        Scanner sc = new Scanner(System.in);
        while (!(enter = sc.nextLine()).equals("end")) {
            taskC1 = new TaskC1();
            taskC1.strObject = enter;
            C.put(taskC1.hashCode(), taskC1.strObject);
        }
        System.out.println(C);
        Map<Object, Integer> reverseMap = new TreeMap<>();

        for (Map.Entry<Integer, Object> pair : C.entrySet()) {
            reverseMap.put(pair.getValue(), pair.getKey());
        }

        Map<Integer, Object> flatMap = new TreeMap<>();

        Iterator<Map.Entry<Object, Integer>> fmi = reverseMap.entrySet().iterator();
        while (fmi.hasNext()) {
            Map.Entry<Object, Integer> pair = fmi.next();
            flatMap.put(pair.getValue(), pair.getKey());
        }
        System.out.println(flatMap);
    }
}




