package instructions.integers;

import instructions.Instruction;
import machine.OperandStack;
import machine.Storage;

/**
 * INEG negates the top value from the OperandStack
 * and pushes the result back to the OperandStack.
 */
public final class INEG extends Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final Integer a = stack.pop(Integer.class);
        stack.push(a == null ? null : -a);
    }

    @Override
    public String toString() {
        return "INEG";
    }
}
