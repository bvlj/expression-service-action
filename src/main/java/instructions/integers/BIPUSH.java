package instructions.integers;

import instructions.Instruction;
import machine.Storage;

/**
 * BIPUSH pushes the given value onto the operand stack.
 */
public final class BIPUSH extends Instruction {

    private final int value;

    /**
     * Default constructor.
     *
     * @param value the value to push
     */
    public BIPUSH(final int value) {
        super();
        this.value = value;
    }

    @Override
    public void execute(final Storage storage) {
        storage.getOperandStack().push(value);
    }

    @Override
    public String toString() {
        return "BIPUSH " + value;
    }
}
