package instructions.factories;

import instructions.Instruction;
import instructions.doubles.DADD;
import instructions.integers.IADD;
import nodes.Type;

/**
 * ADD factory.
 */
public final class ADDFactory {

    private ADDFactory() {
    }

    /**
     * Get the add instruction that for the given type.
     *
     * @param type Type of the add instruction
     * @return the add instruction
     */
    public static Instruction get(final Type type) {
        switch (type) {
            case DOUBLE:
                return new DADD();
            case INT:
                return new IADD();
            default:
                return null;
        }
    }
}
