package by.it.naryshkin.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    private StringBuilder finalString = new StringBuilder();

    public static void main(String[] args) {
        TaskC taskC = new TaskC();
        File dir = new File(dirCheck());
        taskC.listFilesDirs(dir);
        System.out.println(taskC.finalString.toString());
        taskC.print();
    }

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskC.class.getName().replace(TaskC.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;

    }

    private static String dirCheck() {
        return System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "by" +
                File.separator + "it" +
                File.separator + "naryshkin" +
                File.separator;
    }

    private final String writeFilename = dir() + "resultTaskC.txt";

    public void print() {
        try (PrintWriter PW = new PrintWriter(new FileWriter(writeFilename))) {
            PW.print(finalString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listFilesDirs(File dir) {
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    String sFile = "dir:" + file.getName() + "\n";
                    finalString.append(sFile);
                } else {
                    String sDir = "file:" + file.getName() + "\n";
                    finalString.append(sDir);
                }
                listFilesDirs(file);
            }
        }
    }
}






