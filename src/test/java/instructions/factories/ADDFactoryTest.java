package instructions.factories;

import instructions.doubles.DADD;
import instructions.integers.IADD;
import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class ADDFactoryTest {

    @Test
    public void getInt() {
        Assert.assertTrue(ADDFactory.get(Type.INT) instanceof IADD);
    }

    @Test
    public void getDouble() {
        Assert.assertTrue(ADDFactory.get(Type.DOUBLE) instanceof DADD);
    }

    @Test
    public void getNull() {
        Assert.assertNull(ADDFactory.get(Type.INVALID));
    }
}
