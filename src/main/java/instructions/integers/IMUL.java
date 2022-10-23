package instructions.integers;

import instructions.Instruction;
import machine.OperandStack;
import machine.Storage;

/**
 * IMUL multiplies the top two values from the OperandStack
 * and pushes the result back to the OperandStack.
 */
public final class IMUL extends Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final Integer b = stack.pop(Integer.class);
        final Integer a = stack.pop(Integer.class);
        stack.push(a == null | b == null ? null : a * b);
    }

    @Override
    public String toString() {
        return "IMUL";
    }
}
