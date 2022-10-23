package instructions.integers;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class IPOWTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(3);
        stack.push(2);
        IPOW m = new IPOW();
        m.execute(storage);

        Assert.assertNull(stack.pop(Integer.class));
    }

    @Test
    public void testToString() {
        IPOW m = new IPOW();
        Assert.assertEquals("IPOW", m.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2.0);
        stack.push(1.0);
        stack.push(1.0);
        IPOW a = new IPOW();
        a.execute(storage);

        Assert.assertEquals((Double) 2.0, stack.pop(Double.class));
    }
}
