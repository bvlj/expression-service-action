package instructions.integers;

import instructions.doubles.DPOW;
import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class ISUBTest {

    @Test
    public void testExecute() {
        final OperandStack stack;
        stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(5);
        stack.push(2);
        ISUB s = new ISUB();
        s.execute(storage);

        Assert.assertEquals((Integer) 3, stack.pop(Integer.class));
    }

    @Test
    public void testToString() {
        ISUB s = new ISUB();
        Assert.assertEquals("ISUB", s.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2.0);
        stack.push(2.0);
        stack.push(1.0);
        ISUB a = new ISUB();
        a.execute(storage);

        Assert.assertNull(stack.pop(Integer.class));
    }
}
