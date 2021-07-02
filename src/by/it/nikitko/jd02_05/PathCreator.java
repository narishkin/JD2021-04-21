package by.it.nikitko.jd02_05;

public class PathCreator {

    public PathCreator() {
    }

    public static String getPath(Class clazz) {
        String path = clazz.getPackageName() + ".res.language";
        return   path;

    }
}