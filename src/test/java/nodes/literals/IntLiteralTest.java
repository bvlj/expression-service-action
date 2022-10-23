package nodes.literals;

import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class IntLiteralTest {

    @Test
    public void testGetType() {
        Literal l = new IntLiteral(1);
        Assert.assertEquals(Type.INT, l.getType());
    }

    @Test
    public void testGetConstant() {
        Literal l = new IntLiteral(2);
        Assert.assertTrue(l.isConstant());
    }

    @Test
    public void testToString() {
        Literal l = new IntLiteral(3);
        Assert.assertEquals("3", l.toString());
    }
}
