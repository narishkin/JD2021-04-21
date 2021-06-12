package by.it.nikitko.jd01_15;

import java.io.File;

public class PathCreator {

    public PathCreator() {
    }

    public static String getPath(Class clazz) {
        String partOne = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String partTwo = clazz.getPackageName().replace(".", File.separator) + File.separator;
        return partOne + partTwo;

    }
}