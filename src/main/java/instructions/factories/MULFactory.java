package instructions.factories;

import instructions.Instruction;
import instructions.doubles.DMUL;
import instructions.integers.IMUL;
import nodes.Type;

/**
 * MUL factory.
 */
public final class MULFactory {

    private MULFactory() {
    }

    /**
     * Get the mul instruction that for the given type.
     *
     * @param type Type of the mul instruction
     * @return the mul instruction
     */
    public static Instruction get(final Type type) {
        switch (type) {
            case DOUBLE:
                return new DMUL();
            case INT:
                return new IMUL();
            default:
                return null;
        }
    }
}
