package instructions;

import machine.Storage;

/**
 * An IJVM-like instruction.
 */
public abstract class Instruction {

    /**
     * Execute this instruction.
     *
     * @param storage The "memory" to use during the execution
     */
    public abstract void execute(final Storage storage);

    /**
     * Get a String with the disassembled instruction.
     *
     * @return A String-representation of this instruction.
     */
    public String toString() {
        return "?";
    }
}
