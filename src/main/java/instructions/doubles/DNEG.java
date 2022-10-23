package instructions.doubles;

import instructions.Instruction;
import machine.OperandStack;
import machine.Storage;

/**
 * DNEG negates the top value from the OperandStack
 * and pushes the result back to the OperandStack.
 */
public final class DNEG extends Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final Double a = stack.pop(Double.class);
        stack.push(a == null ? null : -a);
    }

    @Override
    public String toString() {
        return "DNEG";
    }
}
