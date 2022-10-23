package nodes.variables;

import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class VariableTest {

    @Test
    public void testGetType() {
        Variable v = new IntVariable("x");
        Assert.assertEquals(Type.INT, v.getType());
    }

    @Test
    public void testIsConstant() {
        Variable v = new IntVariable("y");
        Assert.assertFalse(v.isConstant());
    }
}
