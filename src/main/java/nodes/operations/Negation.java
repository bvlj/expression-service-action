package nodes.operations;

import instructions.factories.NEGFactory;
import machine.Program;
import nodes.Node;

/**
 * An integer negation (e.g., -5, or -x).
 */
public final class Negation extends UnaryOperatorNode {

    /**
     * Create a new Negation node.
     *
     * @param child the operand we will negate
     */
    public Negation(final Node child) {
        super(child, "-");
    }

    @Override
    public void compile(final Program p) {
        super.compile(p);
        p.append(NEGFactory.get(child.getType()));
    }
}
