package instructions.doubles;

import machine.OperandStack;
import machine.Program;
import machine.Storage;
import machine.VariableTable;
import org.junit.Assert;
import org.junit.Test;

public class DLOADTest {

    @Test
    public void testExecute() {
        final Storage storage = new Storage(new OperandStack(), new VariableTable());

        storage.getVariableTable().set("x", 5.3);
        DLOAD l = new DLOAD("x");
        l.execute(storage);

        Assert.assertEquals((Double) 5.3, storage.getOperandStack().pop(Double.class));
    }

    @Test
    public void testToString() {
        DLOAD a = new DLOAD("x");
        Assert.assertEquals("DLOAD x", a.toString());
    }

    @Test
    public void testDLOAD() {
        Storage s = new Storage(new OperandStack(), new VariableTable());
        s.getVariableTable().set("x", 1.0);
        Program p = new Program();
        p.append(new DLOAD("x"));
        p.append(new BDPUSH(4.0));
        p.append(new DADD());
        Assert.assertEquals(String.format("  DLOAD x\n  BDPUSH %1$.1f\n  DADD\n", 4.0), p.toString());
        Assert.assertEquals((Double) 5.0, p.execute(s.getVariableTable(), Double.class));
    }
}
