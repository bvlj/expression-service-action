package instructions.doubles;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class DNEGTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(7.0);
        DNEG n = new DNEG();
        n.execute(storage);

        Assert.assertEquals((Double) (-7.0), stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        DNEG n = new DNEG();
        Assert.assertEquals("DNEG", n.toString());
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2);
        stack.push(1);
        DNEG a = new DNEG();
        a.execute(storage);

        Assert.assertNull(stack.pop(Double.class));
    }
}
