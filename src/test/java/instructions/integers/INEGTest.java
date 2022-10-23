package instructions.integers;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class INEGTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(7);
        INEG n = new INEG();
        n.execute(storage);

        Assert.assertEquals((Integer) (-7), stack.pop(Integer.class));
    }

    @Test
    public void testToString() {
        INEG n = new INEG();
        Assert.assertEquals("INEG", n.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2.0);
        stack.push(2.0);
        INEG a = new INEG();
        a.execute(storage);

        Assert.assertNull(stack.pop(Integer.class));
    }
}
