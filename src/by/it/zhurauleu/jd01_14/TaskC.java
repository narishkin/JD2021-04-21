package by.it.zhurauleu.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class TaskC {
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String PACKAGE = "by" + File.separator + "it"
            + File.separator + "zhurauleu";

    public static void main(String[] args) {
        String resultTxtFile = PathCreator.getFileName(TaskC.class, "resultTaskC.txt");
        FileCreator.createFile(resultTxtFile);
        String workingDirectory = System.getProperty(USER_DIR);
        printDirectoriesToConsole(workingDirectory);
        printDirectoriesToTxt(workingDirectory, resultTxtFile);
    }


    private static void printDirectoriesToConsole(String workingDirectory) {
        String packagePath = workingDirectory + File.separator + SRC + File.separator + PACKAGE;
        File packageDirectory = new File(packagePath);
        File[] directories = packageDirectory.listFiles();
        for (File directory : Objects.requireNonNull(directories)) {
            System.out.printf("dir:%s\n", directory.getName());
            File[] files = directory.listFiles();
            for (File file : Objects.requireNonNull(files)) {
                System.out.printf("file:%s \n", file.getName());
            }
            System.out.println();
        }
    }

    private static void printDirectoriesToTxt(String workingDirectory, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            String packagePath = workingDirectory + File.separator + SRC + File.separator + PACKAGE;
            File packageDirectory = new File(packagePath);
            File[] directories = packageDirectory.listFiles();
            for (File directory : Objects.requireNonNull(directories)) {
                printWriter.printf("dir:%s\n", directory.getName());
                File[] files = directory.listFiles();
                for (File file : Objects.requireNonNull(files)) {
                    printWriter.printf("file:%s \n", file.getName());
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
