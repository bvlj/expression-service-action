package instructions.factories;

import instructions.Instruction;
import instructions.doubles.DPOW;
import instructions.integers.IPOW;
import nodes.Type;

/**
 * MUL factory.
 */
public final class POWFactory {

    private POWFactory() {
    }

    /**
     * Get the pow instruction that for the given type.
     *
     * @param type Type of the pow instruction
     * @return the pow instruction
     */
    public static Instruction get(final Type type) {
        switch (type) {
            case DOUBLE:
                return new DPOW();
            case INT:
                return new IPOW();
            default:
                return null;
        }
    }
}
