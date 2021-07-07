package by.it.naryshkin.jd02_06.calc;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParserTest {
    Parser parser = new Parser();


    @BeforeAll
    void setUp() {
    }


    @Test
    void evaluateScalar_TestA1 () throws Exception {
        String expression = "A=2+5.3";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        double expectedValue = 7.3;
        double actualValue = Double.parseDouble(actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue, 1e-10);
    }
    @Test
    void evaluateScalar_TestA2() throws Exception {
        String expression = "B=A*3.5";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        double expectedValue = 25.55;
        double actualValue = Double.parseDouble(actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue, 1e-10);
    }
    @Test
    void evaluateScalar_TestA3() throws Exception {
        String expression = "B1=B+0.11*-5";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        double expectedValue = 25;
        double actualValue = Double.parseDouble(actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue, 1e-10);
    }
    @Test
    void evaluateScalar_TestA4() throws Exception {
        String expression = "B2=A/2-1";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        double expectedValue = 2.65;
        double actualValue = Double.parseDouble(actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue, 1e-10);
    }

    @Test()
    void evaluateScalarDivisionByZero_TestA5() throws Exception {
        String expression = "Z=5/0";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("Division by zero"));
    }

    @Test()
    void evaluateScalarCreate_TestA6() throws Exception {
        String expression = "1";
        System.out.println(expression);
        Var actualVar = VarCreator.get(expression);
        String expectedValue = "1.0";
        String actualValue = actualVar.toString();
        System.out.println(actualValue);
        Assertions.assertEquals(expectedValue,actualValue);
    }

    @Test
    void evaluateBracket_TestB1() throws Exception {
        String expression = "C=B+(A*2)";
        System.out.println(expression);
        VarRepo.loadVars();
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        double expectedValue = 40.15;
        double actualValue = Double.parseDouble(actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue, 1e-10);
    }
    @Test
    void evaluateBracket_TestB2() throws Exception {
        VarRepo.loadVars();
        String expression = "D=((C-0.15)-20)/(7-5)";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        double expectedValue = 10;
        double actualValue = Double.parseDouble(actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue, 1e-10);
    }
    @Test
    void evaluateVector_TestB3() throws Exception {
        VarRepo.loadVars();
        String expression = "E={2,3}*(10/2)";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        String expectedValue = "{10.0, 15.0}";
        String actualValue = (actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue);
    }
    @Test()
    void evaluateVectorDivisionByZero_TestB4() throws Exception {
        String expression = "Z={1,2,3}/0";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("Division by zero"));
    }

    @Test
    void evaluateVectorSum_TestB5() throws Exception {
        VarRepo.loadVars();
        String expression = "E={1,2,3}+{4,5,6}";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        String expectedValue = "{5.0, 7.0, 9.0}";
        String actualValue = (actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void evaluateUnequalVectorSum_TestB6() throws Exception {
        VarRepo.loadVars();
        String expression = "E={1,2,3}+{4,5,6,7}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("ERROR: Unequal vector length"));
    }

    @Test
    void evaluateUnequalVectorSub_TestB7() throws Exception {
        VarRepo.loadVars();
        String expression = "E={1,2,3}-{4,5,6,7}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("ERROR: Unequal vector length"));
    }
    @Test
    void evaluateUnequalVectorMul_TestB7() throws Exception {
        VarRepo.loadVars();
        String expression = "E={1,2,3}*{4,5,6,7}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("ERROR: Unequal vector length"));
    }
    @Test
    void evaluateVectorDiv_TestB8() throws Exception {
        VarRepo.loadVars();
        String expression = "E={1,2,3}/{4,5,6}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateVectorCreate_TestB9() throws Exception {
        String expression = "{1,2,3}";
        System.out.println(expression);
        Var actualVar = VarCreator.get(expression);
        String expectedValue = "{1.0, 2.0, 3.0}";
        String actualValue = actualVar.toString();
        System.out.println(actualValue);
        Assertions.assertEquals(expectedValue,actualValue);
    }





    @Test
    void evaluateBracket_TestC1() throws Exception {
        VarRepo.loadVars();
        String expression = "F={{1,2,3},{4,5,6},{7,8,9}}*{{1,2},{4,5},{6,3}}*(D*(2+6)/(2+0.5+1.5)/10)";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        String expectedValue = "{{54.0, 42.0}, {120.0, 102.0}, {186.0, 162.0}}";
        String actualValue = (actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test()
    void evaluateMatrixDivisionByZero_TestC2() throws Exception {
        String expression = "Z={{1,2,3},{4,5,6},{7,8,9}}/0";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateMatrixAddVector_TestC3() throws Exception {
        String expression = "Z={{1,2,3},{4,5,6},{7,8,9}}+{1,2,3}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateMatrixSubVector_TestC4() throws Exception {
        String expression = "Z={{1,2,3},{4,5,6},{7,8,9}}-{1,2,3}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("ERROR: Unequal matrices length"));
    }
    @Test()
    void evaluateMatrixMulUnequalSizeMatrix_TestC5() throws Exception {
        String expression = "Z={{1,2,3},{4,5,6},{7,8,9}}*{1,2}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateMatrixDivMatrix_TestC6() throws Exception {
        String expression = "Z={{1,2},{4,5}}/{{1,2},{4,5}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }


    @Test()
    void evaluateScalarAddMatrix_TestC7() throws CalcException {
        String expression = "Z=6+{{1,2},{4,5}}";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        String expectedValue = "{{7.0, 8.0}, {10.0, 11.0}}";
        String actualValue = (actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue);
    }
    @Test()
    void evaluateScalarSubMatrix_TestC8() throws CalcException {
        String expression = "Z=6-{{1,2},{4,5}}";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        String expectedValue = "{{5.0, 4.0}, {2.0, 1.0}}";
        String actualValue = (actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test()
    void evaluateScalarDivMatrix_TestC9() throws Exception {
        String expression = "Z=6/{{1,2},{4,5}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateVectorAddMatrix_TestC10() throws Exception {
        String expression = "Z={1,2}+{{1,2},{4,5}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }

    @Test()
    void evaluateVectorSubMatrix_TestC11() throws Exception {
        String expression = "Z={1,2}-{{1,2},{4,5}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }

    @Test()
    void evaluateVectorMulMatrix_TestC12() throws Exception {
        String expression = "Z={1,2}*{{1,2},{4,5}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateVectorDivMatrix_TestC13() throws Exception {
        String expression = "Z={1,2}/{{1,2},{4,5}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateUnequalMatrixMulMatrix_TestC14() throws Exception {
        String expression = "Z={{1,2},{4,5}}*{{1,2,6},{4,5,7},{4,5,6}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateMatrixMulMatrix_TestC15() throws CalcException {
        String expression = "Z={{1,2},{4,5}}*{{1,2},{4,5}}";
        System.out.println(expression);
        Var actualVar = parser.calc(expression);
        VarRepo.saveVars();
        String expectedValue = "{{9.0, 12.0}, {24.0, 33.0}}";
        String actualValue = (actualVar.toString());
        Assertions.assertEquals(expectedValue, actualValue);
    }
    @Test()
    void evaluateMatrixDivMatrix_TestC16() throws Exception {
        String expression = "Z={{1,2},{5,9}}/{{1,2},{4,5}}";
        System.out.println(expression);
        Throwable thrown = assertThrows(CalcException.class, () -> parser.calc(expression));
        assertTrue(thrown.getMessage().contains("impossible"));
    }
    @Test()
    void evaluateMatrixCreate_TestC17() throws Exception {
        String expression = "{{1,2,3},{4,5,6},{7,8,9}}";
        System.out.println(expression);
        Var actualVar = VarCreator.get(expression);
        String expectedValue = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}";
        String actualValue = actualVar.toString();
        System.out.println(actualValue);
        Assertions.assertEquals(expectedValue,actualValue);
    }
        @AfterAll
    void end(){
        }
    }
