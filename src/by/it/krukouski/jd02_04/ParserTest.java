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
    public void calc_sum() throws CalcException {
        String expression = "2+5.3";
        Var actualVar = parser.calc(expression);
        double expected = 7.3;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_sub() throws CalcException {
        String expression = "4-3.5";
        Var actualVar = parser.calc(expression);
        double expected = 0.5;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_mul() throws CalcException {
        String expression = "2*3";
        Var actualVar = parser.calc(expression);
        double expected = 6;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }


    @Test
    public void calc_div() throws CalcException {
        String expression = "8/2";
        Var actualVar = parser.calc(expression);
        double expected = 4;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected,actual);
    }

    @After
    public void tearDown() {
        System.out.println("Finish");
    }
}