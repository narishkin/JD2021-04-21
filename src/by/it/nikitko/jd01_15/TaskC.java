package by.it.nikitko.jd01_15;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = PathCreator.getPath(TaskC.class);
        System.out.println(path);
       // Path path1 = Paths.get(path);

       // Files currDir1 = new Files(path1);


        while (true) {
            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                break;
            }
            if (inputString.equals("dir")) {
                printDir(path);
            } 
            if (inputString.matches("[cd]")) {
                changeDir(path);
            }
            
        }
    }

    private static void changeDir(String path) {
    }

    private static void printDir(String path) {
        File currDir = new File(path);
        
        System.out.println();
        File[] filesCurrDir = currDir.listFiles();
        assert filesCurrDir != null;
        for (File file : filesCurrDir) {
            if (file.isDirectory()) {
                System.out.println("dir   :" + file.getName());
            } else {
                System.out.println("file  :" + file.getName());
            }
        }
    }
}
