package by.it.nikitko.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = PathCreator.getPath(TaskC.class);
        System.out.print(path);

        while (true) {
            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                break;
            }
            if (inputString.equals("dir")) {
                printDir(path);
                System.out.print(path);
            }
            if (inputString.matches("cd\\s*\\.+")) {
                File currDir = new File(path);
                path = currDir.getParent();
                System.out.print(path + File.separator);
            }
            if (!inputString.equals("dir") & !inputString.matches("cd\\s*\\.+")) {
                path = changeDir(path, inputString);
                System.out.print(path);
            }
        }
    }

    private static String changeDir(String path, String dir) {
        dir = dir.replaceAll("cd\\s*", "");
        System.out.println(dir);
        path = path + File.separator + dir + File.separator;
        return path;
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
