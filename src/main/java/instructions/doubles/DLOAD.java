package instructions.doubles;

import instructions.Instruction;
import machine.Storage;

/**
 * DLOAD loads a variable from the VariableTable to the OperandStack.
 */
public final class DLOAD extends Instruction {

    private final String varName;

    /**
     * Default constructor.
     *
     * @param varName the variable name
     */
    public DLOAD(final String varName) {
        super();
        this.varName = varName;
    }

    @Override
    public void execute(final Storage storage) {
        final Double val = storage.getVariableTable().get(varName, Double.class);
        storage.getOperandStack().push(val);
    }


    @Override
    public String toString() {
        return String.format("DLOAD %1$s", varName);
    }
}
