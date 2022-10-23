package instructions.factories;

import instructions.Instruction;
import instructions.doubles.DSUB;
import instructions.integers.ISUB;
import nodes.Type;

/**
 * SUB factory.
 */
public final class SUBFactory {

    private SUBFactory() {
    }

    /**
     * Get the sub instruction that for the given type.
     *
     * @param type Type of the sub instruction
     * @return the sub instruction
     */
    public static Instruction get(final Type type) {
        switch (type) {
            case DOUBLE:
                return new DSUB();
            case INT:
                return new ISUB();
            default:
                return null;
        }
    }
}
