package by.it.nikitko.jd01_14;

import java.io.File;

public class PathCreator {

    public PathCreator() {
    }

    public static String getPath(Class clazz) {
        String partOne = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String partTwo = clazz.getName().replace(".", File.separator).replace(clazz.getSimpleName(), "");
        return partOne + partTwo;
    }
}