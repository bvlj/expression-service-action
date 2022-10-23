package instructions.integers;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class IMULTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(3);
        stack.push(2);
        IMUL m = new IMUL();
        m.execute(storage);

        Assert.assertEquals((Integer) 6, stack.pop(Integer.class));
    }

    @Test
    public void testToString() {
        IMUL m = new IMUL();
        Assert.assertEquals("IMUL", m.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2.0);
        stack.push(2.0);
        stack.push(1.0);
        IMUL a = new IMUL();
        a.execute(storage);

        Assert.assertNull(stack.pop(Integer.class));
    }
}
