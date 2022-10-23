package instructions.factories;

import instructions.Instruction;
import instructions.doubles.DNEG;
import instructions.integers.INEG;
import nodes.Type;

/**
 * NEG factory.
 */
public final class NEGFactory {

    private NEGFactory() {
    }

    /**
     * Get the neg instruction that for the given type.
     *
     * @param type Type of the neg instruction
     * @return the neg instruction
     */
    public static Instruction get(final Type type) {
        switch (type) {
            case DOUBLE:
                return new DNEG();
            case INT:
                return new INEG();
            default:
                return null;
        }
    }
}
