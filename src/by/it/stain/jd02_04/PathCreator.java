package by.it.stain.jd02_04;
import java.io.File;
public class PathCreator {
    public static final String USER_DIR="user.dir";
    public static final String SRC = "src";

    private PathCreator(){}

    static String getFile(Class<?> Clazz, String fileName){
        String root = System.getProperty(USER_DIR);
        String path = Clazz.getName().replace(Clazz.getSimpleName(),"").replace(".",File.separator);
        return root + File.separator+SRC+File.separator+path+fileName;
    }
}
