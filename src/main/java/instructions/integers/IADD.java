package instructions.integers;

import instructions.Instruction;
import machine.OperandStack;
import machine.Storage;

/**
 * IADD adds the top two values from the OperandStack
 * and pushes the result back to the OperandStack.
 */
public final class IADD extends Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final Integer b = stack.pop(Integer.class);
        final Integer a = stack.pop(Integer.class);
        stack.push(a == null | b == null ? null : a + b);
    }

    @Override
    public String toString() {
        return "IADD";
    }
}
