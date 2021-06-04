package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        int posZero = 0;
        for (; ; ) {
            String value = scanner.next();
            if (value.equals("end")) {
                break;
            }
            int i = Integer.parseInt(value);
            if (i < 0) {
                values.add(i);
            }  if (i == 0) {
                values.add(posZero, i);
            } else {
                values.add(posZero++, i);
            }
        }
        System.out.println(values);
    }
}
