package by.it.nikitko.jd02_04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        parser=new Parser();
    }

    @Test
    void calcA1() throws CalcException {
        String expression = "A=2+5.3";
        Var actualVar = parser.calc(expression);
        double expected = 7.3;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    void calcA2() throws CalcException {
        String expression = "B=A*3.5";
        Var actualVar = parser.calc(expression);
        double expected = 25.55;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    void calcA3() throws CalcException {
        String expression = "B1=B+0.11*-5";
        Var actualVar = parser.calc(expression);
        double expected = 25;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    void calcA4() throws CalcException {
        String expression = "B2=A/2-1";
        Var actualVar = parser.calc(expression);
        double expected = 2.65;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }





}