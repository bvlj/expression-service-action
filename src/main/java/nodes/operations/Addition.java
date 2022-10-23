package nodes.operations;

import instructions.factories.ADDFactory;
import machine.Program;
import nodes.Node;
import nodes.Type;
import nodes.util.BinaryOperationsUtils;

/**
 * An integer addition.
 */
public final class Addition extends BinaryOperationNode {

    /**
     * Create a new nodes.integers.Addition node.
     *
     * @param left  the left operand
     * @param right the right operand
     */
    public Addition(final Node left, final Node right) {
        super(left, right, "+");
    }

    @Override
    public void compile(final Program p) {
        final Type expectedType = BinaryOperationsUtils.addCasting(p, left, right);
        p.append(ADDFactory.get(expectedType));
    }
}
