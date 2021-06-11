package by.it.krukouski.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    static final String TEXT_FILE = "resultTaskC.txt";


    public static void main(String[] args) {
        String s = System.getProperty("user.dir") + File.separator
                + "src" + File.separator
                + "by" + File.separator
                + "it" + File.separator
                + "krukouski" + File.separator;
        File file = new File(s);
        try (PrintWriter printWriter = new PrintWriter
                (new FileWriter
                (PathCreator.getFileName(TaskC.class, TEXT_FILE)))) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isDirectory()) {
                            System.out.println("dir:" + f.getName());
                            printWriter.println("dir:" + f.getName());
                            File[] files1 = f.listFiles();
                            if (files1 != null) {
                                for (File file1 : files1) {
                                    System.out.println("file:" + file1.getName());
                                    printWriter.println("file:" + file1.getName());
                                }
                            }
                        } else if (f.isFile()) {
                            System.out.println("file:" + f.getName());
                            printWriter.println("file:" + f.getName());
                        }
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
