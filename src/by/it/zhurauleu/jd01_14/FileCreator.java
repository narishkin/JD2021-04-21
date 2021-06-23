package by.it.zhurauleu.jd01_14;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    private FileCreator() {
    }

    protected static void createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("created file " + filePath);
            } else {
                System.out.println("file is already existed " + filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
