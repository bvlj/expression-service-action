package instructions.doubles;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class DSUBTest {

    @Test
    public void testExecute() {
        final OperandStack stack;
        stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(5.0);
        stack.push(2.0);
        DSUB s = new DSUB();
        s.execute(storage);

        Assert.assertEquals((Double) 3.0, stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        DSUB s = new DSUB();
        Assert.assertEquals("DSUB", s.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2);
        stack.push(1);
        stack.push(1);
        DSUB a = new DSUB();
        a.execute(storage);

        Assert.assertNull(stack.pop(Double.class));
    }
}
