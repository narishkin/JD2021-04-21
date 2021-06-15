package by.it.sapazhkou.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskC {

    public String path;
    public static String pathFileResult;

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        Class<TaskC> aClass = TaskC.class;
        String pathProjectUser = aClass.getPackageName().replace("jd01_14", "").
                replace(".", File.separator);
        String pathProject = aClass.getName().
                replace(aClass.getSimpleName(), "").
                replace(".", File.separator);
        String pathDir = root + File.separator + "src" + File.separator + pathProjectUser;
        String pathFileResult = root + File.separator + "src" + File.separator + pathProject + "resultTaskC.txt";

        printToConsole(pathDir);

        try(PrintWriter printWriter = new PrintWriter(pathFileResult)){
           printToConsole(pathDir,printWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void printToConsole(String path){
        File dir = new File(path);
        String[] elementsDir = dir.list();
        for (int i = 0; i < elementsDir.length; i++) {
            File file = new File(path, elementsDir[i]);
            if (file.isDirectory()) {
                System.out.println("dir:" + file.getName());
                printToConsole(file.getAbsolutePath());
            } else {
                System.out.println("file:" + file.getName());
            }
        }
    }
    public static void printToConsole(String path,PrintWriter printWriter){
        File dir = new File(path);
        String[] elementsDir = dir.list();
        for (int i = 0; i < elementsDir.length; i++) {
            File file = new File(path, elementsDir[i]);
            if (file.isDirectory()) {
                printWriter.println("dir:" + file.getName());
                printToConsole(file.getAbsolutePath(),printWriter);
            } else {
                printWriter.println("file:" + file.getName());
            }
        }
    }

}

