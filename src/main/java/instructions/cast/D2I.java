package instructions.cast;

import instructions.Instruction;
import machine.Storage;

/**
 * Convert an {@link Integer} to a {@link Double}.
 */
public final  class D2I extends Instruction {

    @Override
    public void execute(final Storage storage) {
        Double i = storage.getOperandStack().pop(Double.class);
        storage.getOperandStack().push(i == null ? null : i.intValue());
    }

    @Override
    public String toString() {
        return "D2I";
    }
}
