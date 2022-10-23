package instructions.factories;

import instructions.doubles.DMUL;
import instructions.integers.IMUL;
import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class MULFactoryTest {

    @Test
    public void getInt() {
        Assert.assertTrue(MULFactory.get(Type.INT) instanceof IMUL);
    }

    @Test
    public void getDouble() {
        Assert.assertTrue(MULFactory.get(Type.DOUBLE) instanceof DMUL);
    }

    @Test
    public void getNull() {
        Assert.assertNull(MULFactory.get(Type.INVALID));
    }
}
