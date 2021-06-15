package by.it.krukouski.jd01_15;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        String s = System.getProperty("user.dir") + File.separator
                + "src" + File.separator
                + "by" + File.separator
                + "it" + File.separator
                + "krukouski" + File.separator
                + "jd01_15";
        Scanner sc = new Scanner(System.in);
        File file = new File(s);
        System.out.println(file);
            String value = sc.next();
            switch (value) {
                case ("cd") :
                    System.out.println(file.getParent());
                case ("dir") :
                    System.out.println(Arrays.toString(file.listFiles()));
                case ("end") :
                    break;
            }
    }
}
