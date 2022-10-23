package instructions.cast;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class D2ITest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(1.0);
        D2I d = new D2I();
        d.execute(storage);

        Assert.assertEquals((Integer) 1, stack.pop(Integer.class));
    }

    @Test
    public void testTwo() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        stack.push(1);
        stack.push(1);
        D2I d = new D2I();
        d.execute(storage);

        Assert.assertEquals((Integer) 1, stack.pop(Integer.class));
    }


    @Test
    public void testToString() {
        D2I b = new D2I();
        Assert.assertEquals("D2I", b.toString());
    }

}
