package nodes;

import machine.Program;

/**
 * An abstract syntax tree (AST) node.
 */
public abstract class Node {

    /**
     * Get the type of values produced by this node.
     *
     * @return the type of this node
     */
    public Type getType() {
        // to be implemented in subclasses
        return Type.INVALID;
    }

    /**
     * Get whether this node always evaluates to the exact same value.
     *
     * @return whether this node produces a constant value
     */
    public abstract boolean isConstant();

    /**
     * Compile this node into the given Program.
     *
     * @param p The src.machine to append this node to
     */
    public abstract void compile(final Program p);

    /**
     * Decompile this node into a string.
     * Note that the resulting string may have
     * extra parentheses.
     *
     * @return a String representation of this AST
     */
    public String toString() {
        // to be implemented in subclasses
        return "?";
    }
}
