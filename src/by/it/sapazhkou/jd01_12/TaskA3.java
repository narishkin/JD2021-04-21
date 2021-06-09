package by.it.sapazhkou.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        int position = 0;
        for (; ; ) {
            String next = scanner.next();
            if (next.equals("end")) {
                break;
            }
            int i = Integer.parseInt(next);
            if (i < 0) {
                values.add(i);
            } else if (i == 0) {
                values.add(position, i);
            } else {
                values.add(position++,i);
            }
        }
        System.out.println(values.toString());
    }


}
