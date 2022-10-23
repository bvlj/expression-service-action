package nodes.literals;

import nodes.Node;

/**
 * A Literal is an AST node that
 * corresponds to a literal integer value
 * (a number in the source code).
 */
public abstract class Literal<T> extends Node {

    protected final T value;

    /**
     * Create a new Literal node.
     *
     * @param value the integer value this node evaluates to
     */
    public Literal(final T value) {
        super();
        this.value = value;
    }

    @Override
    public final boolean isConstant() {
        return true;
    }

    @Override
    public final String toString() {
        return String.valueOf(value);
    }

}
