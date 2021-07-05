package by.it.nakov.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
        System.out.println("One, two, Three");
    }

    @Test
    public void evaluateScalarTest() throws Exception {
        String expression = "A=2+-4*-2/8";
        var actualVar = parser.evaluate(expression);
        double expected = 3.0;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
    }

    @After
    public void tearDown() {
        System.out.println("Finished");
    }
}

