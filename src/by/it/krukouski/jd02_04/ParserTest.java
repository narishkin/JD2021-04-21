package by.it.krukouski.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser=new Parser();
        System.out.println("Start");
    }

    @Test
    public void calc() throws CalcException {
        String expression = "A=2+5.3";
        Var actualVar = parser.calc(expression);
        double expected = 7.3;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }

    @After
    public void tearDown() {
        System.out.println("Finish");
    }
}