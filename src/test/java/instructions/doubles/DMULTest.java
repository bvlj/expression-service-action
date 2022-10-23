package instructions.doubles;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class DMULTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(3.0);
        stack.push(2.0);
        DMUL m = new DMUL();
        m.execute(storage);

        Assert.assertEquals((Double) 6.0, stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        DMUL m = new DMUL();
        Assert.assertEquals("DMUL", m.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2);
        stack.push(2);
        stack.push(1);
        DMUL a = new DMUL();
        a.execute(storage);

        Assert.assertNull(stack.pop(Double.class));
    }
}
