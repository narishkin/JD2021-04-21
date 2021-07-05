package by.it.krukouski.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_add_vector_and_scalar() throws CalcException {
        String expression = "{1,2,3}+2";
        Var actualVar = parser.calc(expression);
        String expected = "{3.0, 4.0, 5.0}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_add_vector_and_vector() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("{1,2,3}+{1,2,3}");
        expected = "{2.0, 4.0, 6.0}";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("{1,2,3}+{1,2,3,4}");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_sub_vector_and_scalar() throws CalcException {
        String expression = "{4,3,2}-1";
        Var actualVar = parser.calc(expression);
        String expected = "{3.0, 2.0, 1.0}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_sub_vector_and_vector() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("{1,2,3}-{1,2,3}");
        expected = "{0.0, 0.0, 0.0}";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("{1,2,3}-{1,2,3,4}");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_mul_vector_and_scalar() throws CalcException {
        String expression = "{4,3,2}*2";
        Var actualVar = parser.calc(expression);
        String expected = "{8.0, 6.0, 4.0}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_mul_vector_and_vector() throws CalcException {
        double actual;
        double expected;
        Var actualVar = parser.calc("{2,3,4}*{1,2,3}");
        expected = 20.0;
        actual = Double.parseDouble(actualVar.toString());
        assertEquals(expected, actual, 1e-10);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("{1,2,3}*{1,2,3,4}");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_div_vector_and_scalar() throws CalcException {
        String expression = "{6,4,2}/2";
        Var actualVar = parser.calc(expression);
        String expected = "{3.0, 2.0, 1.0}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_div_vector_and_vector() throws CalcException {
        String expression = "{4,3,2}/{4,3,2}";
        try {
            parser.calc(expression);
        } catch (CalcException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void calc_add_matrix_and_scalar() throws CalcException {
        String expression = "{{1,2},{3,4}}+2";
        Var actualVar = parser.calc(expression);
        String expected = "{{3.0, 4.0}, {5.0, 6.0}}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_add_matrix_and_vector() throws CalcException {
        String expression = "{{1,2},{3,4}}+{1,2,3}";
        try {
            parser.calc(expression);
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_add_matrix_and_matrix() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("{{1,2},{3,4}}+{{1,2},{3,4}}");
        expected = "{{2.0, 4.0}, {6.0, 8.0}}";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("{1,2},{3,4}}+{{1,2},{3,4},{5,6}}");
        } catch (CalcException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void calc_sub_matrix_and_scalar() throws CalcException {
        String expression = "{{1,2},{3,4}}-1";
        Var actualVar = parser.calc(expression);
        String expected = "{{0.0, 1.0}, {2.0, 3.0}}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_sub_matrix_and_vector() throws CalcException {
        String expression = "{{1,2},{3,4}}-{1,2,3}";
        try {
            parser.calc(expression);
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_sub_matrix_and_matrix() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("{{6,7},{8,9}}-{{1,2},{3,4}}");
        expected = "{{5.0, 5.0}, {5.0, 5.0}}";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("{1,2},{3,4}}-{{1,2},{3,4},{5,6}}");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_mul_matrix_and_scalar() throws CalcException {
        String expression = "{{1,2},{3,4}}*2";
        Var actualVar = parser.calc(expression);
        String expected = "{{2.0, 4.0}, {6.0, 8.0}}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_mul_matrix_and_vector() throws CalcException {
        String expression = "{{1,2},{3,4}}*{1,2}";
        Var actualVar = parser.calc(expression);
        String expected = "{5.0, 11.0}";
        String actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    public void calc_mul_matrix_and_matrix() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("{{1,2},{3,4}}*{{1,2},{3,4}}");
        expected = "{{7.0, 10.0}, {15.0, 22.0}}";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("{1,2},{3,4}}*{{1,2},{3,4},{5,6}}");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_createScalar() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("S=2");
        expected = "2.0";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("S=b");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_createVector() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("V={1,2,3}");
        expected = "{1.0, 2.0, 3.0}";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("V=b");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calc_createMatrix() throws CalcException {
        String actual;
        String expected;
        Var actualVar = parser.calc("M={{1,2,3},{2,3,4}}");
        expected = "{{1.0, 2.0, 3.0}, {2.0, 3.0, 4.0}}";
        actual = actualVar.toString();
        assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);

        try {
            parser.calc("M=b");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() {
        System.out.println("Finish");
    }
}