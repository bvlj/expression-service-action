package machine;

/**
 * A value holder for the stack with a stack pointer.
 * It can contain any kind of objects.
 */
public final class StackValuesHolder {
    private static final int SIZE = 10;

    private final Object[] pool;
    private int sp;

    /**
     * Default constructor.
     */
    public StackValuesHolder() {
        pool = new Object[SIZE];
        sp = -1;
    }

    /**
     * Push a value to the stack.
     *
     * @param val the value
     * @param <T> the type
     */
    public final <T> void push(final T val) {
        if (val == null) {
            System.err.println("Failed to insert a null object!");
            return;
        }
        pool[++sp] = val;
    }

    /**
     * Pop the TOS.
     *
     * @param clazz the class
     * @param <T> the type
     * @throws IllegalAccessException If TOS is not the requested type
     * @return the TOS
     */
    @SuppressWarnings("unchecked") // We are doing a check that the java compiler cannot infer
    public final <T> T pop(final Class<T> clazz) throws IllegalAccessException {
        final Object o = pool[sp--];
        if (clazz.isInstance(o)) {
            return (T) o;
        }
        throw new IllegalAccessException("TOS is not an int!");
    }
}
