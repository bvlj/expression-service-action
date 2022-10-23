package instructions.doubles;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class DDIVTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(6.0);
        stack.push(2.0);
        DDIV d = new DDIV();
        d.execute(storage);

        Assert.assertEquals((Double) 3.0, stack.pop(Double.class));
    }

    @Test
    public void testNull() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(2);
        stack.push(2);
        stack.push(1);
        DDIV a = new DDIV();
        a.execute(storage);

        Assert.assertNull(stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        DDIV a = new DDIV();
        Assert.assertEquals("DDIV", a.toString());
    }
}
