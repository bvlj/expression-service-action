package instructions.integers;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class IDIVTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(6);
        stack.push(2);
        IDIV d = new IDIV();
        d.execute(storage);

        Assert.assertEquals((Integer) 3, stack.pop(Integer.class));
    }

    @Test
    public void testToString() {
        IDIV a = new IDIV();
        Assert.assertEquals("IDIV", a.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2.0);
        stack.push(2.0);
        stack.push(1.0);
        IDIV a = new IDIV();
        a.execute(storage);

        Assert.assertNull(stack.pop(Integer.class));
    }
}
