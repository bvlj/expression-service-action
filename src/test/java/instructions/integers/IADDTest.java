package instructions.integers;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class IADDTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(1);
        stack.push(2);
        IADD a = new IADD();
        a.execute(storage);

        Assert.assertEquals((Integer) 3, stack.pop(Integer.class));
    }

    @Test
    public void testToString() {
        IADD a = new IADD();
        Assert.assertEquals("IADD", a.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2.0);
        stack.push(2.0);
        stack.push(1.0);
        IADD a = new IADD();
        a.execute(storage);

        Assert.assertNull(stack.pop(Integer.class));
    }
}
