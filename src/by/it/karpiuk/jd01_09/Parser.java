package by.it.karpiuk.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc (String expression){
        //2.0*2.0
        expression = expression.replace(" ", "");
        String[] operand= expression.split(Patterns.operation, 2);
        if (operand.length==1){
            return Var.createVar(operand[0]);
        }
        Var one = Var.createVar(operand[0]);
        Var second = Var.createVar(operand[1]);
        if (one==null || second==null) {

            System.out.println("Incorrect expression");
            return null;
        }
        Pattern p=Pattern.compile(Patterns.operation);
        Matcher m= p.matcher(expression);
        if (m.find()){
            String operation = m.group();
            switch (operation){
                case "+": return one.add(second);
                case "-": return one.sub(second);
                case "*": return one.mul(second);
                case "/": return one.div(second);
            }
        }
        return null;
    }
}
