package nodes.operations;

import instructions.factories.SUBFactory;
import machine.Program;
import nodes.Node;
import nodes.Type;
import nodes.util.BinaryOperationsUtils;

/**
 * An integer subtraction.
 */
public final class Subtraction extends BinaryOperationNode {

    /**
     * Create a new Subtraction node.
     *
     * @param left  the left operand
     * @param right the right operand
     */
    public Subtraction(final Node left, final Node right) {
        super(left, right, "-");
    }

    @Override
    public void compile(final Program p) {
        final Type expectedType = BinaryOperationsUtils.addCasting(p, left, right);
        p.append(SUBFactory.get(expectedType));
    }
}
