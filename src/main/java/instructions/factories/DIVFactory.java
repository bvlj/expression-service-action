package instructions.factories;

import instructions.Instruction;
import instructions.doubles.DDIV;
import instructions.integers.IDIV;
import nodes.Type;

/**
 * Div factory.
 */
public final class DIVFactory {

    private DIVFactory() {
    }

    /**
     * Get the div instruction that for the given type.
     *
     * @param type Type of the div instruction
     * @return the div instruction
     */
    public static Instruction get(final Type type) {
        switch (type) {
            case DOUBLE:
                return new DDIV();
            case INT:
                return new IDIV();
            default:
                return null;
        }
    }
}
