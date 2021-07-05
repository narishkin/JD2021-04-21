package by.it.karpiuk.jd01_15;

import java.io.File;

public class PathCreator {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    private PathCreator() {
    }

    static String getFileName(Class<?> aClass, String fileName) {
        String root = System.getProperty(USER_DIR);
        String path = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + SRC + File.separator + path + fileName;
    }
}
