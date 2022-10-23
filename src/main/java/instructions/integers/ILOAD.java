package instructions.integers;

import instructions.Instruction;
import machine.Storage;

/**
 * ILOAD load a variable from the VariableTable to the OperandStack.
 */
public final class ILOAD extends Instruction {

    private final String varName;

    /**
     * Default constructor.
     *
     * @param varName the variable name
     */
    public ILOAD(final String varName) {
        super();
        this.varName = varName;
    }

    @Override
    public void execute(final Storage storage) {
        final Integer val = storage.getVariableTable().get(varName, Integer.class);
        storage.getOperandStack().push(val);
    }


    @Override
    public String toString() {
        return String.format("ILOAD %1$s", varName);
    }
}
