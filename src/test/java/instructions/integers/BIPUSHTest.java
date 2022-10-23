package instructions.integers;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class BIPUSHTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        BIPUSH b = new BIPUSH(1);
        b.execute(storage);

        Assert.assertEquals((Integer) 1, stack.pop(Integer.class));
    }

    @Test
    public void testToString() {
        BIPUSH b = new BIPUSH(1);
        Assert.assertEquals("BIPUSH 1", b.toString());
    }
}
