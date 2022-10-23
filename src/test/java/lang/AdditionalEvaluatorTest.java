package lang;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AdditionalEvaluatorTest {

    @Test
    public void test() {
        int actualResult = new Evaluator().evaluate("1+2-3");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLiteral() {
        final String sourceCode = "12";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 12;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddition() {
        final String sourceCode = "12+2";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 14;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLeadingPlus() {
        final String sourceCode = "+12";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 12;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNegation() {
        final String sourceCode = "-12";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = -12;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSubtraction() {
        final String sourceCode = "12-2";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 10;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLeadingPlusAndAddition() {
        final String sourceCode = "+12+2";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 14;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMultiplication() {
        final String sourceCode = "12*2";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 24;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDivision() {
        final String sourceCode = "12/2";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSeqPlus() {
        final String sourceCode = "1+2+3";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSeqTimes() {
        final String sourceCode = "1*2*3";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPlusAndTimes() {
        final String sourceCode = "1+2*3";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 9;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testParenSingleLiteral() {
        final String sourceCode = "(1)";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testParenExp() {
        final String sourceCode = "(1+2)*3";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 9;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testParenExpEnd() {
        final String sourceCode = "1+(2*3)";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDoubleParenExp() {
        final String sourceCode = "((1+2))";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testParenExpMiddle() {
        final String sourceCode = "0+(1+2)*3";
        int actualResult = new Evaluator().evaluate(sourceCode);
        int expectedResult = 9;
        assertEquals(expectedResult, actualResult);
    }

}
