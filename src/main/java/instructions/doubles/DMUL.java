package instructions.doubles;

import instructions.Instruction;
import machine.OperandStack;
import machine.Storage;

/**
 * DMUL multiplies the top two values from the OperandStack
 * and pushes the result back to the OperandStack.
 */
public final class DMUL extends Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final Double b = stack.pop(Double.class);
        final Double a = stack.pop(Double.class);
        stack.push(a == null | b == null ? null : a * b);
    }

    @Override
    public String toString() {
        return "DMUL";
    }
}
