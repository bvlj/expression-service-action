package instructions.factories;

import instructions.doubles.DPOW;
import instructions.integers.IPOW;
import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class POWFactoryTest {

    @Test
    public void getInt() {
        Assert.assertTrue(POWFactory.get(Type.INT) instanceof IPOW);
    }

    @Test
    public void getDouble() {
        Assert.assertTrue(POWFactory.get(Type.DOUBLE) instanceof DPOW);
    }

    @Test
    public void getNull() {
        Assert.assertNull(POWFactory.get(Type.INVALID));
    }
}
