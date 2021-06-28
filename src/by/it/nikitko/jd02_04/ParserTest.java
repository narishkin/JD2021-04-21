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
    void scalarA1() throws CalcException {
        String expression = "A=2+5.3";
        Var actualVar = parser.calc(expression);
        double expected = 7.3;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    void scalarA2() throws CalcException {
        String expression = "B=A*3.5";
        Var actualVar = parser.calc(expression);
        double expected = 25.55;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    void scalarA3() throws CalcException {
        String expression = "B1=B+0.11*-5";
        Var actualVar = parser.calc(expression);
        double expected = 25;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    void scalarA4() throws CalcException {
        String expression = "B2=A/2-1";
        Var actualVar = parser.calc(expression);
        double expected = 2.65;
        double actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected,actual,1e-10);
    }
    @Test
    void matrixC1() throws CalcException {
        String expression = "{{1,2},{8,3}}-2";
        Var actualVar = parser.calc(expression);
        String expected = "{{-1.0, 0.0}, {6.0, 1.0}}";
        String actual = (actualVar.toString());
        assertEquals(expected,actual);
    }
    @Test
    void matrixC2() throws CalcException {
        String expression = "{{1,2},{8,3}} * {{1,2},{8,3}}";
        Var actualVar = parser.calc(expression);
        String expected = "{{17.0, 8.0}, {32.0, 25.0}}";
        String actual = (actualVar.toString());
        assertEquals(expected,actual);
    }
    @Test
    void matrixC3() throws CalcException {
        String expression = "{{1,2},{8,3}}+{{1,2},{8,3}}";
        Var actualVar = parser.calc(expression);
        String expected = "{{2.0, 4.0}, {16.0, 6.0}}";
        String actual = (actualVar.toString());
        assertEquals(expected,actual);
    }
    @Test
    void scalarCreate() throws CalcException {
        String expression = "5.0";
        Var actualVar = Var.createVar(expression);
        String expected = "5.0";
        String actual = (actualVar.toString());
        assertEquals(expected,actual);
    }
    @Test
    void vectorCreate() throws CalcException {
        String expression = "{2.0, 4.0}";
        Var actualVar = Var.createVar(expression);
        String expected = "{2.0, 4.0}";
        String actual = (actualVar.toString());
        assertEquals(expected,actual);
    } @Test
    void matrixCreate() throws CalcException {
        String expression = "{{2.0, 4.0}, {16.0, 6.0}}";
        Var actualVar = Var.createVar(expression);
        String expected = "{{2.0, 4.0}, {16.0, 6.0}}";
        String actual = (actualVar.toString());
        assertEquals(expected,actual);
    }






}