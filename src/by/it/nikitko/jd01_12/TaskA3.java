package by.it.nikitko.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int pozZero = 0;
        while (true) {
            String value = scanner.next();
            if (value.equals("end")) {
                break;
            }
            int currentNumber = Integer.parseInt(value);
            if ((currentNumber < 0)) {
                numbers.add(currentNumber);
            }
            else if (currentNumber == 0) {
                numbers.add(pozZero, currentNumber);
            } else {
                numbers.add(pozZero++, currentNumber);
            }
        }
        System.out.println(numbers);
    }
}

//[2, 4, 6, 8, 0, 9, 7, 5, 3, 1, 0, 0, 0, -1, -3, -5, -7, -9, -8, -6, -4, -2]
//[2, 4, 6, 8, 0, 9, 7, 5, 3, 1, 0, 0, 0, -1, -3, -5, -7, -9, -8, -6, -4, -2]