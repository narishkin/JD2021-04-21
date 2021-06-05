package by.it.mogonov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int pos = 0;
        for (; ; ) {
            String value = sc.next();
            if (value.equals("end")) {
                break;
            }

            int i = Integer.parseInt(value);

            if (i < 0) {
                arr.add(i);
            } else if (i == 0) {
                arr.add(pos, i);
            } else {
                arr.add(pos++, i);
            }
            System.out.println(arr);
        }

    }
}