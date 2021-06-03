package by.it.nikitko.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int pozZero = 0;
        while (true) {
            String value = scanner.next();
            if (value.equals("end")){
                break;
            }
            int currentNumber =Integer.parseInt(value);

            if (currentNumber==0){
                numbers.add(pozZero,currentNumber);
            }
            if ((currentNumber<0)){
                numbers.add(currentNumber);
            }
            else {
              numbers.add(pozZero++,currentNumber);
            }
        }
        System.out.println(numbers);
    }
}

