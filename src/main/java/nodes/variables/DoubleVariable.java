package nodes.variables;

import instructions.doubles.DLOAD;
import machine.Program;
import nodes.Type;

public final class DoubleVariable extends Variable {

    /**
     * Default constructor.
     *
     * @param varName the name
     */
    public DoubleVariable(final String varName) {
        super(varName);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }

    @Override
    public void compile(final Program p) {
        p.append(new DLOAD(varName));
    }
}
