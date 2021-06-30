package by.it._classwork_.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
        System.out.println("Делай раз делай два");
    }

    @Test
    public void evaluateScalarTest() throws Exception {
        String expression = "A=2+-4*-2/8";
        Var actualVar = parser.evaluate(expression);
        double expected = 3.0;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Закончили упражнение!");
    }
}