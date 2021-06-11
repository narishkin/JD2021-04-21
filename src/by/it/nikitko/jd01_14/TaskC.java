package by.it.nikitko.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {
    private static final String TXT_RESULT = "resultTaskC.txt";
    public static void main(String[] args) {


        File currDir = new File(PathCreator.getPath(TaskC.class));
        File destDir = new File(currDir.getParent());

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(PathCreator.getPath(TaskA.class) + TXT_RESULT))) {

            List<File> filesDestDir = Arrays.asList(destDir.listFiles());
            for (File file : filesDestDir) {
                if (file.isDirectory()) {
                    System.out.println("dir:" + file.getName());
                    printWriter.println("dir:" + file.getName());
                    List<File> filesInDir = Arrays.asList(file.listFiles());
                    for (File file1 : filesInDir) {
                        System.out.println("    file:" + file1.getName());
                        printWriter.println("    file:" + file1.getName());
                    }
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
