package by.it.stain.jd01_15;

import java.io.File;
class PatchCreator {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    private PatchCreator() {
    }

    static String getFileName(Class<?> clazz, String fileName) {
        String root = System.getProperty(USER_DIR);
        String path = clazz
                .getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return root + File.separator + SRC + File.separator + path + fileName;

    }
}
