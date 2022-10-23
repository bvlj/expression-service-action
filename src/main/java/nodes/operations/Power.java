package nodes.operations;

import instructions.factories.POWFactory;
import machine.Program;
import nodes.Node;
import nodes.Type;
import nodes.util.BinaryOperationsUtils;

public class Power extends BinaryOperationNode {

    /**
     * Create a new Multiplication node.
     *
     * @param left  the left operand
     * @param right the right operand
     */
    public Power(final Node left, final Node right) {
        super(left, right, "^");
    }

    @Override
    public void compile(final Program p) {
        final Type expectedType = BinaryOperationsUtils.addCasting(p, left, right);
        p.append(POWFactory.get(expectedType));
    }
}
