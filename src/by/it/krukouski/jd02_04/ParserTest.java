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
    public void calc_add_scalars() throws CalcException {
        String expression = "2+5.3";
        Var actualVar = parser.calc(expression);
        double expected = 7.3;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_sub_scalars() throws CalcException {
        String expression = "4-3.5";
        Var actualVar = parser.calc(expression);
        double expected = 0.5;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_mul_scalars() throws CalcException {
        String expression = "2*3";
        Var actualVar = parser.calc(expression);
        double expected = 6;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }


    @Test
    public void calc_div_scalars() throws CalcException {
        String expression = "8/2";
        Var actualVar = parser.calc(expression);
        double expected = 4;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected,actual);
    }

    @Test
    public void calc_add_vector_and_scalar() throws CalcException {
        String expression = "{1,2,3}+2";
        Var actualVar = parser.calc(expression);
        String expected = "{3.0, 4.0, 5.0}";
        String actual = actualVar.toString();
        assertEquals(expected,actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_add_vector_and_vector() throws CalcException {
        String expression = "{1,2,3}+{1,2,3}";
        Var actualVar = parser.calc(expression);
        String expected = "{2.0, 4.0, 6.0}";
        String actual = actualVar.toString();
        assertEquals(expected,actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_sub_vector_and_scalar() throws CalcException {
        String expression = "{4,3,2}-1";
        Var actualVar = parser.calc(expression);
        String expected = "{3.0, 2.0, 1.0}";
        String actual = actualVar.toString();
        assertEquals(expected,actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_sub_vector_and_vector() throws CalcException {
        String expression = "{2,3,4}-{1,2,3}";
        Var actualVar = parser.calc(expression);
        String expected = "{1.0, 1.0, 1.0}";
        String actual = actualVar.toString();
        assertEquals(expected,actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_mul_vector_and_scalar() throws CalcException {
        String expression = "{4,3,2}*2";
        Var actualVar = parser.calc(expression);
        String expected = "{8.0, 6.0, 4.0}";
        String actual = actualVar.toString();
        assertEquals(expected,actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_mul_vector_and_vector() throws CalcException {
        String expression = "{2,3,4}*{1,2,3}";
        Var actualVar = parser.calc(expression);
        double expected = 20.0;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_div_vector_and_scalar() throws CalcException {
        String expression = "{6,4,2}/2";
        Var actualVar = parser.calc(expression);
        String expected = "{3.0, 2.0, 1.0}";
        String actual = actualVar.toString();
        assertEquals(expected,actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }
    @Test
    public void calc_div_vector_and_vector() throws CalcException {
        String expression = "{4,3,2}/{4,3,2}";
        Var actualVar = parser.calc(expression);
        String expected = "ERROR: Division impossible";
        String actual = actualVar.toString();
        fail();
        //assertEquals(expected,actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }


    @After
    public void tearDown() {
        System.out.println("Finish");
    }
}