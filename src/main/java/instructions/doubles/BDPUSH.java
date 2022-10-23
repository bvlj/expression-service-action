package instructions.doubles;

import instructions.Instruction;
import machine.Storage;

/**
 * BDPUSH pushes the given value onto the operand stack.
 */
public final class BDPUSH extends Instruction {
    private final double value;

    /**
     * Default constructor.
     *
     * @param value the value to push
     */
    public BDPUSH(final double value) {
        super();
        this.value = value;
    }

    @Override
    public void execute(final Storage storage) {
        storage.getOperandStack().push(value);
    }

    @Override
    public String toString() {
        return String.format("BDPUSH %1$.1f", value);
    }
}
