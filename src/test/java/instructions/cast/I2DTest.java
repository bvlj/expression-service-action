package instructions.cast;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class I2DTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(1);
        I2D d = new I2D();
        d.execute(storage);

        Assert.assertEquals((Double) 1.0, stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        I2D b = new I2D();
        Assert.assertEquals("I2D", b.toString());
    }

    @Test
    public void testTwo() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(1.0);
        stack.push(1.0);
        I2D d = new I2D();
        d.execute(storage);

        Assert.assertEquals((Double) 1.0, stack.pop(Double.class));
    }

}
