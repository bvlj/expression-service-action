package nodes.operations;

import machine.Program;
import nodes.Node;
import nodes.Type;
import nodes.literals.IntLiteral;
import nodes.variables.IntVariable;
import org.junit.Assert;
import org.junit.Test;

public class BinaryOperationNodeTest {

    @Test
    public void testType() {
        BinaryOperationNode n = new TestOp(
                new IntLiteral(46),
                new IntLiteral(2)
        );

        Assert.assertEquals(Type.INT, n.getType());
    }

    @Test
    public void testIsConstant() {
        BinaryOperationNode a = new TestOp(
                new IntLiteral(46),
                new IntLiteral(2)
        );
        Assert.assertTrue(a.isConstant());

        BinaryOperationNode b = new TestOp(
                new IntLiteral(46),
                new IntVariable("x")
        );
        Assert.assertFalse(b.isConstant());

        BinaryOperationNode c = new TestOp(
                new IntVariable("x"),
                new IntLiteral(46)
        );
        Assert.assertFalse(c.isConstant());
    }

    @Test
    public void testToString() {
        BinaryOperationNode n = new TestOp(
                new IntLiteral(46),
                new IntLiteral(2)
        );

        Assert.assertEquals("(46&2)", n.toString());
    }

    /**
     * Mock the nodes.integers.BinaryOperationNode class
     */
    private static class TestOp extends BinaryOperationNode {

        TestOp(Node left, Node right) {
            super(left, right, "&");
        }

        @Override
        public void compile(Program p) {
            // DO nothing
        }
    }
}
