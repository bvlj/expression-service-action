package machine;

import instructions.Instruction;

import java.util.ArrayList;

/**
 * A compiled src.machine,
 * consisting of a list of IJVM-like src.instructions.
 */
public final class Program {

    private final ArrayList<Instruction> code;

    /**
     * Create a new empty src.machine.
     */
    public Program() {
        this.code = new ArrayList<>();
    }

    /**
     * Append the given instruction to this src.machine.
     *
     * @param instruction The instruction to append
     */
    public final void append(final Instruction instruction) {
        if (instruction != null) {
            code.add(instruction);
        }
    }

    /**
     * Execute this src.machine, returning the result.
     * The result is the top element of the operand stack,
     * after executing all src.instructions.
     *
     * @param returnClass the return class
     * @param <T> the type
     * @return The result of the execution.
     */
    public final <T> T execute(final Class<T> returnClass) {
        final VariableTable variables = new VariableTable();
        return execute(variables, returnClass);
    }

    /**
     * Execute this src.machine, returning the result.
     * The result is the top element of the operand stack,
     * after executing all src.instructions.
     *
     * @param variables The variables with their values
     *                  (accessed by instructions.integers.ILOAD src.instructions)
     * @param returnClass the return class
     * @param <T> the type
     * @return The result of the execution.
     */
    public final <T> T execute(final VariableTable variables, final Class<T> returnClass) {
        final OperandStack stack = new OperandStack();
        final Storage storage = new Storage(stack, variables);
        for (final Instruction instruction : code) {
            instruction.execute(storage);
        }
        return stack.pop(returnClass);
    }

    /**
     * Disassemble this src.machine into a String,
     * with one bytecode instruction per line.
     *
     * @return A String-representation of this src.machine.
     */
    @Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final Instruction instruction : code) {
            builder.append("  ");
            builder.append(instruction.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}
