package instructions.doubles;

import instructions.Instruction;
import machine.OperandStack;
import machine.Storage;

/**
 * DSUB subtracts the top value from the second-to-top value
 * of the OperandStack,
 * and pushes the result back to the OperandStack.
 */
public final class DSUB extends Instruction {

    @Override
    public void execute(final Storage storage) {
        final OperandStack stack = storage.getOperandStack();
        final Double b = stack.pop(Double.class);
        final Double a = stack.pop(Double.class);
        stack.push(a == null | b == null ? null : a - b);
    }

    @Override
    public String toString() {
        return "DSUB";
    }
}
