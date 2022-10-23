package instructions.doubles;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class BDPUSHTest {

    @Test
    public void testExecute() {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, new VariableTable());

        BDPUSH b = new BDPUSH(1.0);
        b.execute(storage);

        Assert.assertEquals((Double) 1.0, stack.pop(Double.class));
    }

    @Test
    public void testToString() {
        BDPUSH b = new BDPUSH(1.0);
        Assert.assertEquals(String.format("BDPUSH %1$.1f", 1d), b.toString());
    }
}
