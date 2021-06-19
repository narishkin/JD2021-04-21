package by.it.nikitko.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = PathCreator.getPath(TaskC.class);
        System.out.print(path);

        while (true) {
            try {

                String inputString = scanner.nextLine();
                if (inputString.equals("end")) {
                    break;
                }
                if (inputString.equals("dir")) {
                    printDir(path);
                    System.out.print(path+File.separator);
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
            } catch (NullPointerException e) {
                System.out.println("Системе не удается найти указанный путь.");
                System.out.print(path+File.separator);
              //  e.printStackTrace();
            }
        }
    }

    private static String changeDir(String path, String dir) {
        dir = dir.replaceAll("cd\\s*", "");
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
                Path path1 = Paths.get(path+File.separator+ file.getName());
                try {
                    Object timeLustMod= (Files.getAttribute(path1,"lastModifiedTime"));
                    String dirName = (file.getName());
                    System.out.printf("%15s <DIR> %10s\n",timeLustMod,dirName);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Path path1 = Paths.get(path+File.separator+ file.getName());
                try {
                    Object size =  Files.getAttribute(path1,"size");

                    String fileName =  file.getName();
                    System.out.printf("%15s  %10s\n",size.toString(),fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
