package by.it.krukouski.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {

    static final String REGEX = "cd\\s.+";

    public static void main(String[] args) {
        String s = System.getProperty("user.dir") + File.separator
                + "src" + File.separator
                + "by" + File.separator
                + "it" + File.separator
                + "krukouski" + File.separator
                + "jd01_15";
        System.out.println(s);
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String value = sc.nextLine();

            if (value.contains("cd")) {
                if (value.matches(REGEX)) {
                    value = value.replaceAll("cd\\s*", "");
                    s = s + File.separator + value + File.separator;
                    System.out.println(s);
                } else {
                    File file = new File(s);
                    s = file.getParent();
                    System.out.println(s + File.separator);
                }
            }
            if (value.equals("dir")) {
                getDir(s);
            }
            if (value.equals("end")) {
                break;
            }

        }
    }

    private static void getDir(String s) {
        File file = new File(s);
        File[] arrayFiles = file.listFiles();
        for (File elementArrayFiles : arrayFiles) {
            if (elementArrayFiles.isFile()) {
                Path path = Paths.get(s + File.separator + elementArrayFiles.getName());
                try {
                    System.out.printf("%20s         %10s %10s\n",
                            Files.getAttribute(path, "lastModifiedTime"),
                            Files.getAttribute(path, "size"),
                            elementArrayFiles.getName()
                    );

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (elementArrayFiles.isDirectory()) {
                Path path = Paths.get(s + File.separator + elementArrayFiles.getName());
                try {
                    System.out.printf("%20s  <DIR>  %10s\n",
                            Files.getAttribute(path, "lastModifiedTime"),
                            elementArrayFiles.getName()
                    );

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
