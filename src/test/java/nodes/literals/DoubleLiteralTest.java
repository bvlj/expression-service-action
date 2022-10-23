package nodes.literals;

import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class DoubleLiteralTest {

    @Test
    public void testGetType() {
        Literal l = new DoubleLiteral(1.1);
        Assert.assertEquals(Type.DOUBLE, l.getType());
    }

    @Test
    public void testGetConstant() {
        Literal l = new DoubleLiteral(2.3);
        Assert.assertTrue(l.isConstant());
    }

    @Test
    public void testToString() {
        Literal l = new DoubleLiteral(3.3);
        Assert.assertEquals("3.3", l.toString());
    }
}
