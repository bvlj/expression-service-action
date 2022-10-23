package machine;

/**
 * The OperandStack is a stack holding
 * the temporary values during execution.
 * (If you took Computer Architecture at USI,
 * you should remember this).
 */
public final class OperandStack {

    private final StackValuesHolder stack;

    /**
     * Create an empty OperandStack,
     * with space for at most 10 elements!
     */
    public OperandStack() {
        stack = new StackValuesHolder();
    }

    /**
     * Push the given value on the stack.
     *
     * @param value The value to push
     * @param <T> the type
     */
    public final <T> void push(final T value) {
        stack.push(value);
    }

    /**
     * Pop the top-most value off the stack.
     * Returns null if the TOS type does not match the provided one.
     *
     * @param clazz The expected class for the TOS
     * @param <T> the type
     * @return the top-most value
     */
    public final <T> T pop(final Class<T> clazz) {
        try {
            return stack.pop(clazz);
        } catch (IllegalAccessException ignored) {
            return null;
        }
    }
}
