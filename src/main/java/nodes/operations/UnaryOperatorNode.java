package nodes.operations;

import machine.Program;
import nodes.Node;
import nodes.Type;

/**
 * An operation that takes 1 argument
 */
public abstract class UnaryOperatorNode extends Node {

    protected final Node child;
    private final String operator;

    /**
     * Default constructor.
     *
     * @param child    the argument
     * @param operator the operator
     */
    public UnaryOperatorNode(final Node child, final String operator) {
        super();
        this.child = child;
        this.operator = operator;
    }

    @Override
    public final Type getType() {
        return child.getType();
    }

    @Override
    public final boolean isConstant() {
        return child.isConstant();
    }

    @Override
    public void compile(final Program p) {
        child.compile(p);
    }

    @Override
    public final String toString() {
        return String.format("(%1$s%2$s)", operator, child.toString());
    }
}
