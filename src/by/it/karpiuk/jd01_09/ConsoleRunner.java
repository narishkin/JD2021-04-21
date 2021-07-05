package by.it.karpiuk.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    static final String KEY_STOP_APP = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    //    String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner input = new Scanner(System.in);
        for (;;){
            String expression = input.nextLine();
            if (!expression.equals(KEY_STOP_APP)){
                Var var = parser.calc(expression);
                printer.print(var);
            }else {
                break;
            }
        }
    //    while (!(line=scanner.nextLine()).equals("end")){
    //        Var result = parser.calc(line);
    //        printer.print(result);

        }
    }

