package nodes.variables;

import instructions.integers.ILOAD;
import machine.Program;
import nodes.Type;

/**
 * An int variable.
 */
public final class IntVariable extends Variable {

    /**
     * Default constructor.
     *
     * @param varName the name
     */
    public IntVariable(final String varName) {
        super(varName);
    }

    @Override
    public Type getType() {
        return Type.INT;
    }

    @Override
    public void compile(final Program p) {
        p.append(new ILOAD(varName));
    }

}
