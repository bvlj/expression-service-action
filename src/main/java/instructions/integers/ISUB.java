package instructions.integers;

import instructions.Instruction;
import machine.OperandStack;
import machine.Storage;

/**
 * ISUB subtracts the top value from the second-to-top value
 * of the OperandStack,
 * and pushes the result back to the OperandStack.
 */
public final class ISUB extends Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final Integer b = stack.pop(Integer.class);
        final Integer a = stack.pop(Integer.class);
        stack.push(a == null | b == null ? null : a - b);
    }

    @Override
    public String toString() {
        return "ISUB";
    }
}
