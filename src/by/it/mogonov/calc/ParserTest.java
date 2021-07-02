package by.it.mogonov.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
        System.out.println("ввод");
    }

    @Test

    public void evaluateScalarTest() throws Exception {
        String expression = "A=2+5.3" ;
        Var actualVar = parser.evaluate(expression);
        double expendet = 7.3;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expendet, actual, 1e-10);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("конец");
    }
}