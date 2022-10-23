package instructions.doubles;

import instructions.integers.IPOW;
import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class DPOWTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(3.0);
        stack.push(2.0);
        DPOW m = new DPOW();
        m.execute(storage);

        Assert.assertEquals((Double) 9.0, stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        DPOW m = new DPOW();
        Assert.assertEquals("DPOW", m.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2);
        stack.push(2);
        stack.push(1);
        DPOW a = new DPOW();
        a.execute(storage);

        Assert.assertNull(stack.pop(Double.class));
    }
}
