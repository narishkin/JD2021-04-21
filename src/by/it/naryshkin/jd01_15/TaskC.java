package by.it.naryshkin.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + TaskC.class.getName().replace(".", File.separator);
        File file = new File(path);
        File currentDirectory = new File(file.getParent());

        operation(currentDirectory);
    }

    private static void operation(File currentDirectory) {
        SimpleDateFormat simpleDateFormat;
        Scanner sc = new Scanner(System.in);
        String s;
        while (!(s = sc.nextLine()).equals("end")) {
            boolean existDir = false;
            String[] operand = s.split(" ");

            if (operand[0].equals("dir")) {
                long filesSize=0;
                int dirCounter=0;
                System.out.println("Directory of " + currentDirectory.toString() + "\n");
                for (File content : Objects.requireNonNull(currentDirectory.listFiles())) {
                    Date date = new Date(content.lastModified());
                    simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy   hh:mm   ");
                    if (content.isDirectory()){
                        dirCounter++;
                        System.out.printf("%20s<DIR>%10d %-30s\n", simpleDateFormat.format(date), content.length(), content.getName());
                    } else {
                        filesSize = filesSize + content.length();
                        System.out.printf("%20s%10d %-30s\n",simpleDateFormat.format(date) , content.length(), content.getName());
                    }
                }
                System.out.printf("%15d File(s) %d bytes\n", Objects.requireNonNull(currentDirectory.listFiles()).length-dirCounter, filesSize);
                System.out.printf("%15d Dir(s) %d bytes free\n", dirCounter, currentDirectory.getFreeSpace());
            }

            if (operand.length > 1 && operand[0].equals("cd") && operand[1].equals("..")) {
                currentDirectory = currentDirectory.getParentFile();
            }

            if (operand.length > 1 && operand[0].equals("cd") && !operand[1].equals("..")) {
                for (File content : currentDirectory.listFiles()) {
                    if (content.getName().equals(operand[1])) {
                        existDir = true;
                    }
                }
                if (!existDir){
                    System.out.println("No such directory");
                }
                for (File content : currentDirectory.listFiles()) {
                    if (content.getName().equals(operand[1])) {
                        currentDirectory = new File(currentDirectory + File.separator + content.getName());
                        break;
                    }
                }
            }

            if (!operand[0].equals("dir")&& !operand[0].equals("cd")) {
                System.out.println("Bad command");
            }

        }
    }
}

