package nodes.util;

import instructions.Instruction;
import instructions.cast.D2I;
import instructions.cast.I2D;
import machine.Program;
import nodes.Node;
import nodes.Type;

import static nodes.Type.*;

public final class BinaryOperationsUtils {

    private BinaryOperationsUtils() {
    }

    /*
     * Order:
     * 1. Invalid
     * 2. Double
     * 3. Float
     * 4. Long
     * 5. Int
     */

    /**
     * Determine the type of a binary expression involving 2 src.nodes.
     *
     * @param a the first node
     * @param b the second node
     * @return the type of the expression
     */
    public static Type determine(final Node a, final Node b) {
        switch (a.getType()) {
            case INT:
                return intAnd(b.getType());
            case DOUBLE:
                return doubleAnd(b.getType());
            default:
                return INVALID;
        }
    }

    /**
     * Add casting for a binary operation
     *
     * @param p the program
     * @param left left child
     * @param right right child
     * @return expected type for the binary operation
     */
    public static Type addCasting(final Program p, final Node left, final Node right) {
        final Type expectedType = BinaryOperationsUtils.determine(left, right);

        left.compile(p);
        final Instruction castLeft = BinaryOperationsUtils.castTo(left, expectedType);
        p.append(castLeft);
        right.compile(p);
        final Instruction castRight = BinaryOperationsUtils.castTo(right, expectedType);
        p.append(castRight);

        return expectedType;
    }

    private static Type intAnd(final Type other) {
        /*
         * Int -> Int
         * Double -> Double
         * Invalid -> Invalid
         */
        return other;
    }

    private static Type doubleAnd(final Type other) {
        /*
         * Int -> Double
         * Double -> Double
         * Invalid -> Invalid
         */
        return other == INVALID ? INVALID : DOUBLE;
    }

    private static Instruction castTo(final Node node, final Type type) {
        final Type nodeType = node.getType();
        if (nodeType == INT) {
            if (type == DOUBLE) {
                return new I2D();
            }
        } else if (nodeType == DOUBLE) {
            if (type == INT) {
                return new D2I();
            }
        }

        return null;
    }
}
