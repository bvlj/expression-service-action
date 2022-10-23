package lang;

import machine.Program;

/**
 * An Evaluator can evaluate a source code expression.
 */
public final class Evaluator {

    /**
     * Evaluate the given source code expression.
     *
     * @param sourceCode The expression to evaluate
     * @return the resulting value
     */
    public int evaluate(final String sourceCode) {
        final Compiler compiler = new Compiler();
        final Program program = compiler.compile(sourceCode);
        final Integer result = program.execute(Integer.class);
        return result == null ? -1 : result;
    }
}
