package instructions.doubles;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class DADDTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(1.0);
        stack.push(2.0);
        DADD a = new DADD();
        a.execute(storage);

        Assert.assertEquals((Double) 3.0, stack.pop(Double.class));
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2);
        stack.push(1);
        stack.push(2);
        DADD a = new DADD();
        a.execute(storage);

        Assert.assertNull(stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        DADD a = new DADD();
        Assert.assertEquals("DADD", a.toString());
    }
}
