package nodes.operations;

import nodes.Node;
import nodes.Type;
import nodes.literals.IntLiteral;
import nodes.variables.IntVariable;
import org.junit.Assert;
import org.junit.Test;

public class UnaryOperatorNodeTest {

    @Test
    public void testGetType() {
        TestUnaryOperatorNode n = new TestUnaryOperatorNode(
                new IntLiteral(1)
        );

        Assert.assertEquals(Type.INT, n.getType());
    }

    @Test
    public void testIsConstant() {
        TestUnaryOperatorNode a = new TestUnaryOperatorNode(
                new IntLiteral(2)
        );

        Assert.assertTrue(a.isConstant());

        TestUnaryOperatorNode b = new TestUnaryOperatorNode(
                new IntVariable("x")
        );
        Assert.assertFalse(b.isConstant());
    }

    @Test
    public void testToString() {
        TestUnaryOperatorNode n = new TestUnaryOperatorNode(
                new IntLiteral(3)
        );

        Assert.assertEquals("(!3)", n.toString());
    }

    private static class TestUnaryOperatorNode extends UnaryOperatorNode {

        TestUnaryOperatorNode(Node child) {
            super(child, "!");
        }
    }
}
