package instructions.cast;


import instructions.Instruction;
import machine.Storage;

/**
 * Convert an {@link Integer} to a {@link Double}.
 */
public final class I2D extends Instruction {

    @Override
    public void execute(final Storage storage) {
        Integer i = storage.getOperandStack().pop(Integer.class);
        storage.getOperandStack().push(i == null ? null : (double) i);
    }

    @Override
    public String toString() {
        return "I2D";
    }
}
