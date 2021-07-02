package by.it.mogonov.jd01_14;

import java.io.File;

public class PathCreator {

     public static final String USER_DIR = "user.dir";
     public static final String SRC = "src";

     private PathCreator() {

     }

      public static String getFileName(Class<?> aClass, String filename) {
         String root = System.getProperty(USER_DIR);
         String path = aClass
                 .getName()
                 .replace(aClass.getSimpleName(), "")
                 .replace(".", File.separator);
         return root + File.separator + SRC + File.separator + path + filename;
     }

 }







