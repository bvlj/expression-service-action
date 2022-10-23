package lang;

import nodes.Node;
import nodes.literals.IntLiteral;
import nodes.operations.*;
import nodes.variables.IntVariable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This test class will fully test all the aspects of all the rules
 * of the Arith language.
 *
 * <code>
 * EXPRESSION   ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
 * TERM         ::= FACTOR { ( "*" | "/" ) FACTOR }
 * FACTOR       ::= Literal |
 * Identifier|
 * "(" EXPRESSION ")"
 * </code>
 */
public class AdditionalArithParserTest {

    @Test
    public void testLiteral() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntLiteral(12);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testAddition() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12+2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testLeadingPlus() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "+12";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntLiteral(12);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testNegation() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "-12";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Negation(new IntLiteral(12));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testSubtraction() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12-2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Subtraction(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testLeadingPlusAndAddition() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "+12+2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testMultiplication() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12*2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testDivision() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12/2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Division(new IntLiteral(12), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testAdditionOfVariables() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "a+b";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new IntVariable("a"), new IntVariable("b"));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testSeqPlus() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "1+2+3";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot =
                new Addition(new Addition(new IntLiteral(1), new IntLiteral(2)), new IntLiteral(3));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testSeqTimes() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "1*2*3";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(new Multiplication(new IntLiteral(1),
                new IntLiteral(2)), new IntLiteral(3));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testPlusAndTimes() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "1+2*3";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(new Addition(new IntLiteral(1),
                new IntLiteral(2)), new IntLiteral(3));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testParenSingleLiteral() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(1)";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntLiteral(1);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testParenSingleVariable() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(a)";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new IntVariable("a");
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testParenExp() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(1+2)*3";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(new Addition(new IntLiteral(1),
                new IntLiteral(2)), new IntLiteral(3));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testParenExpEnd() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "1+(2*3)";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new IntLiteral(1),
                new Multiplication(new IntLiteral(2), new IntLiteral(3)));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testDoubleParenExp() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "((1+2))";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new IntLiteral(1), new IntLiteral(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testParenExpVarsAndNums() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(1+ab)*3";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(
                new Addition(new IntLiteral(1), new IntVariable("ab")), new IntLiteral(3));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testParenExpMiddle() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "0+(1+2)*3";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(
                new Addition(new IntLiteral(0),
                        new Addition(new IntLiteral(1), new IntLiteral(2))
                ),
                new IntLiteral(3)
        );
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
}
