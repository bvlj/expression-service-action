package instructions;

import machine.Storage;
import org.junit.Assert;
import org.junit.Test;

public class InstructionTest {

    @Test
    public void testDefaults() {
        Instruction i = new MockInstruction();

        Assert.assertEquals("?", i.toString());
    }

    private static class MockInstruction extends Instruction {

        public void execute(Storage storage) {
            // Do nothing
        }
    }
}
