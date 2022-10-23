package nodes.variables;

import nodes.Node;

/**
 * A value holder
 */
public abstract class Variable extends Node {

    protected final String varName;

    /**
     * Default constructor.
     *
     * @param varName the variable name held by this variable
     */
    public Variable(final String varName) {
        super();
        this.varName = varName;
    }

    @Override
    public final boolean isConstant() {
        return false;
    }

    @Override
    public final String toString() {
        return varName;
    }
}
