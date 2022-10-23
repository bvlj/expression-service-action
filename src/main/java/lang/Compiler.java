package lang;

import machine.Program;
import nodes.Node;

/**
 * A Compiler converts a source code String
 * into a compiled Program.
 */
public final class Compiler {

    /**
     * Compile a program in the Arith language.
     * @param sourceCode The source code of the program in the Arith language
     * @return the compiled program
     */
    public Program compile(final String sourceCode) {
        final ArithParser parser = new ArithParser();
        final Program program = new Program();
        Node n = parser.parse(sourceCode);
        n.compile(program);
        return program;
    }

}
