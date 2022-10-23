package instructions.factories;

import instructions.doubles.DDIV;
import instructions.integers.IDIV;
import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class DIVFactoryTest {

    @Test
    public void getInt() {
        Assert.assertTrue(DIVFactory.get(Type.INT) instanceof IDIV);
    }

    @Test
    public void getDouble() {
        Assert.assertTrue(DIVFactory.get(Type.DOUBLE) instanceof DDIV);
    }

    @Test
    public void getNull() {
        Assert.assertNull(DIVFactory.get(Type.INVALID));
    }
}
