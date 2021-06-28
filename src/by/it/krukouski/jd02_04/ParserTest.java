package by.it.krukouski.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
        System.out.println("Start");
    }

    @Test
    public void calc_1() throws CalcException {
        String expression = "A=2+5.3";
        Var actualVar = parser.calc(expression);
        double expected = 7.3;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_2() throws CalcException {
        String expression = "B=A*3.5";
        Var actualVar = parser.calc(expression);
        double expected = 25.55;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_3() throws CalcException {
        String expression = "B1=B+0.11*-5";
        Var actualVar = parser.calc(expression);
        double expected = 25;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }


    @Test
    public void calc_4() throws CalcException {
        String expression = "B2=A/2-1";
        Var actualVar = parser.calc(expression);
        double expected = 2.65;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected,actual);
    }

    @After
    public void tearDown() {
        System.out.println("Finish");
    }
}