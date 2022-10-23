package nodes.operations;

import nodes.Node;
import nodes.Type;
import nodes.util.BinaryOperationsUtils;

/**
 * An operation that takes 2 arguments
 */
public abstract class BinaryOperationNode extends Node {

    protected final Node left;
    protected final Node right;

    private final String operator;

    /**
     * Create a new binary operator node.
     *
     * @param left     the left operand
     * @param right    the right operand
     * @param operator the operator
     */
    public BinaryOperationNode(final Node left,
                               final Node right,
                               final String operator) {
        super();
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public Type getType() {
        return BinaryOperationsUtils.determine(left, right);
    }

    @Override
    public final boolean isConstant() {
        return left.isConstant() && right.isConstant();
    }

    @Override
    public final String toString() {
        return String.format("(%1$s%2$s%3$s)", left.toString(), operator, right.toString());
    }
}
