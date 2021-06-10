package by.it.sapazhkou.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        Map<String, Integer> result = new HashMap<String, Integer>();

        for (; ; ) {
            String word = scanner.next();
            word = word.replaceAll("[\\s\\/\\;\\.\\,\\—\\-\\?\\!\\\"\\:\\(\\)]+", "");
            if (word.equals("end")) {
                break;
            }
            words.add(word);
        }

        for (String element : words) {
            Integer count = result.get(element);
            if (count == null) {
                count = 0;
            }
            result.put(element, count + 1);
        }

        Set set = result.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry map = (Map.Entry) i.next();
            System.out.println(map.getKey() + "=" + map.getValue());
        }

    }


}
