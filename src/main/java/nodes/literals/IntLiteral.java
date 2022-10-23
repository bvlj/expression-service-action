package nodes.literals;

import instructions.integers.BIPUSH;
import machine.Program;
import nodes.Type;

/**
 * A literal for type int
 */
public final class IntLiteral extends Literal<Integer> {

    /**
     * Default constructor.
     *
     * @param value the value
     */
    public IntLiteral(final int value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.INT;
    }

    @Override
    public void compile(final Program p) {
        p.append(new BIPUSH(value));
    }

}
