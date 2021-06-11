package by.it.nikitko.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {
    public static void main(String[] args) {


        File currDir = new File(PathCreator.getPath(TaskC.class));
        File destDir = new File(currDir.getParent());


        List<File> filesDestDir = Arrays.asList(destDir.listFiles());
        for (File file : filesDestDir) {
            if (file.isDirectory()) {
                System.out.println("dir:" + file.getName());
                List<File> filesInDir = Arrays.asList(file.listFiles());
                for (File file1 : filesInDir) {
                    System.out.println("    file:" + file1.getName());
                }
            }
        }
    }
}
