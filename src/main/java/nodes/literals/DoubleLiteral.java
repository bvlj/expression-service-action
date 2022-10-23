package nodes.literals;

import instructions.doubles.BDPUSH;
import machine.Program;
import nodes.Type;

/**
 * A literal of type double
 */
public final class DoubleLiteral extends Literal<Double> {

    /**
     * Default constructor.
     *
     * @param value the value
     */
    public DoubleLiteral(final double value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }

    @Override
    public void compile(final Program p) {
        p.append(new BDPUSH(value));
    }

}
