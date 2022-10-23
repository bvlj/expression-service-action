package instructions.factories;

import instructions.doubles.DSUB;
import instructions.integers.ISUB;
import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class SUBFactoryTest {

    @Test
    public void getInt() {
        Assert.assertTrue(SUBFactory.get(Type.INT) instanceof ISUB);
    }

    @Test
    public void getDouble() {
        Assert.assertTrue(SUBFactory.get(Type.DOUBLE) instanceof DSUB);
    }

    @Test
    public void getNull() {
        Assert.assertNull(SUBFactory.get(Type.INVALID));
    }
}
