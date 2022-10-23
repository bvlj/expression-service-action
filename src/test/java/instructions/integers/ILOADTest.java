package instructions.integers;

import machine.OperandStack;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class ILOADTest {

    @Test
    public void testExecute() {
        final Storage storage = new Storage(new OperandStack(), new VariableTable());

        storage.getVariableTable().set("x", 5);
        ILOAD l = new ILOAD("x");
        l.execute(storage);

        Assert.assertEquals((Integer) 5, storage.getOperandStack().pop(Integer.class));
    }

    @Test
    public void testToString() {
        ILOAD a = new ILOAD("x");
        Assert.assertEquals("ILOAD x", a.toString());
    }
}
