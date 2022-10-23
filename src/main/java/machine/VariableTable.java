package machine;

import java.util.HashMap;
import java.util.Map;


/**
 * A table of variables
 * (a map from variable names to variable values).
 */
public final class VariableTable {

    private final Map<String, Object> variables;

    /**
     * Create a new empty variable table.
     */
    public VariableTable() {
        variables = new HashMap<>();
    }

    /**
     * Get the value of the variable with the given name.
     *
     * @param name The name of the variable.
     * @param clazz the class
     * @param <T> the type
     * @return The value of the variable with the given name.
     */
    @SuppressWarnings("unchecked") // We are doing a check that the java compiler can't infer
    public final <T> T get(final String name, final Class<T> clazz) {
        final Object o = variables.get(name);
        if (clazz.isInstance(o)) {
            return (T) o;
        }
        return null;
    }

    /**
     * Set the value of the variable with the given name.
     *
     * @param name  The name of the variable.
     * @param value The new value of the variable.
     * @param <T> the type
     */
    public final <T> void set(final String name, final T value) {
        variables.put(name, value);
    }

}