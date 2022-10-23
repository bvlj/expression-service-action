package instructions.factories;

import instructions.doubles.DNEG;
import instructions.integers.INEG;
import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

public class NEGFactoryTest {

    @Test
    public void getInt() {
        Assert.assertTrue(NEGFactory.get(Type.INT) instanceof INEG);
    }

    @Test
    public void getDouble() {
        Assert.assertTrue(NEGFactory.get(Type.DOUBLE) instanceof DNEG);
    }

    @Test
    public void getNull() {
        Assert.assertNull(NEGFactory.get(Type.INVALID));
    }
}
