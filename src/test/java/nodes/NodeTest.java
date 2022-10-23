package nodes;

import machine.Program;
import nodes.literals.DoubleLiteral;
import nodes.literals.IntLiteral;
import nodes.operations.*;
import nodes.variables.DoubleVariable;
import nodes.variables.IntVariable;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testNodeDefaults() {
        Node e = new MockedNode();
        assertEquals(Type.INVALID, e.getType());
        assertEquals("?", e.toString());
    }

    @Test
    public void testIntLiteral() {
        Node e = new IntLiteral(5);
        assertTrue(e.isConstant());
        assertEquals("5", e.toString());
    }

    @Test
    public void testIntNegation() {
        Node e = new Negation(new IntLiteral(5));
        assertTrue(e.isConstant());
        assertEquals("(-5)", e.toString());
    }

    @Test
    public void testIntAddition() {
        Node e = new Addition(new IntLiteral(5), new IntLiteral(6));
        assertTrue(e.isConstant());
        assertEquals("(5+6)", e.toString());
    }

    @Test
    public void testIntSubtraction() {
        Node e = new Subtraction(new IntLiteral(5), new IntLiteral(6));
        assertTrue(e.isConstant());
        assertEquals("(5-6)", e.toString());
    }

    @Test
    public void testIntMultiplication() {
        Node e = new Multiplication(new IntLiteral(2), new IntLiteral(7));
        assertTrue(e.isConstant());
        assertEquals("(2*7)", e.toString());
    }

    @Test
    public void testIntDivision() {
        Node e = new Division(new IntLiteral(8), new IntLiteral(1));
        assertTrue(e.isConstant());
        assertEquals("(8/1)", e.toString());
    }

    @Test
    public void testIntVariable() {
        Node e = new Addition(new IntLiteral(2), new IntVariable("x"));
        assertFalse(e.isConstant());
        assertEquals("(2+x)", e.toString());
    }

    @Test
    public void testDoubleLiteral() {
        Node e = new DoubleLiteral(5.3);
        assertTrue(e.isConstant());
        assertEquals("5.3", e.toString());
    }

    @Test
    public void testDoubleNegation() {
        Node e = new Negation(new DoubleLiteral(5.0));
        assertTrue(e.isConstant());
        assertEquals("(-5.0)", e.toString());
    }

    @Test
    public void testDoubleAddition() {
        Node e = new Addition(new DoubleLiteral(5.3), new DoubleLiteral(6.1));
        assertTrue(e.isConstant());
        assertEquals("(5.3+6.1)", e.toString());
    }

    @Test
    public void testDoubleSubtraction() {
        Node e = new Subtraction(new DoubleLiteral(5.3), new DoubleLiteral(6));
        assertTrue(e.isConstant());
        assertEquals("(5.3-6.0)", e.toString());
    }

    @Test
    public void testDoubleMultiplication() {
        Node e = new Multiplication(new DoubleLiteral(2), new DoubleLiteral(7.1));
        assertTrue(e.isConstant());
        assertEquals("(2.0*7.1)", e.toString());
    }

    @Test
    public void testDoubleDivision() {
        Node e = new Division(new DoubleLiteral(8), new DoubleLiteral(1));
        assertTrue(e.isConstant());
        assertEquals("(8.0/1.0)", e.toString());
    }

    @Test
    public void testDoubleVariable() {
        Node e = new Addition(new DoubleLiteral(2), new DoubleVariable("x"));
        assertFalse(e.isConstant());
        assertEquals("(2.0+x)", e.toString());
    }


    private static final class MockedNode extends Node {

        public boolean isConstant() {
            return false;
        }

        public void compile(Program p) {
            // Do nothing
        }
    }
}
