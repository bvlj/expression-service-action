package lang;

import nodes.Node;
import nodes.literals.IntLiteral;
import nodes.operations.*;
import nodes.variables.IntVariable;
import token.LexicalAnalyzer;
import token.Token;
import token.TokenType;

/**
 * A Parser for our Arith language
 * (a simple language of arithmetic expressions).
 *
 * <code>
 * EXPRESSION   ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
 * TERM         ::= FACTOR { ( "*" | "/" ) FACTOR }
 * FACTOR       ::= Literal |
 * Identifier|
 * "(" EXPRESSION ")"
 * </code>
 */
public final class ArithParser implements Parser {

    private LexicalAnalyzer lexer;


    /**
     * Parse a program in the Arith language.
     *
     * @param sourceCode The source code of the program in the Arith language
     * @return an AST of the program
     */
    public Node parse(final String sourceCode) {
        this.lexer = new LexicalAnalyzer(sourceCode);
        // fetch first token
        lexer.fetchNextToken();
        // now parse the EXPRESSION
        return parseExpression();
    }

    /**
     * Parse an expression.
     * This assumes the lexer already points to the first token of this expression.
     *
     * <p>EBNF:
     * <code>
     * EXPRESSION ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
     * </code>
     *
     * @return a Node representing the expression
     */
    private Node parseExpression() {
        Token token = lexer.getCurrentToken();

        // - davanti
        if (token.getType() == TokenType.MINUS) {
            lexer.fetchNextToken();
            return new Negation(
                    parseExpression()
            );
        }
        return parseTerm();
    }

    /**
     * Parse a term.
     * This assumes the lexer already points to the first token of this term.
     *
     * <p>EBNF:
     * <code>
     * TERM ::= FACTOR { ( "*" | "/" ) FACTOR }
     * </code>
     *
     * @return a Node representing the term
     */
    private Node parseTerm() {
        Node result = parseFactor();

        while (true) {
            final Node first = result;
            lexer.fetchNextToken();
            final Token op = lexer.getCurrentToken();
            if (!isOperation(op)) {
                return result;
            }

            lexer.fetchNextToken();
            final Node next = parseFactor();

            final Node child;
            switch (op.getType()) {
                case MINUS:
                    child = new Subtraction(first, next);
                    break;
                case PLUS:
                    child = new Addition(first, next);
                    break;
                case SLASH:
                    child = new Division(first, next);
                    break;
                case STAR:
                    child = new Multiplication(first, next);
                    break;
                default:
                    child = first;
                    break;
            }

            result = child;
        }
    }

    /**
     * Parse a factor.
     * This assumes the lexer already points to the first token of this factor.
     *
     * <p>EBNF:
     * <code>
     * FACTOR ::=
     * Literal |
     * Identifier |
     * "(" EXPRESSION ")"
     * </code>
     *
     * @return a Node representing the factor
     */
    private Node parseFactor() {
        final Token token = lexer.getCurrentToken();
        final String value = token.getText();

        switch (token.getType()) {
            case LITERAL:
                return new IntLiteral(Integer.parseInt(value));
            case IDENTIFIER:
                return new IntVariable(value);
            default:
                lexer.fetchNextToken();
                return parseExpression();
        }
    }

    /**
     * Check whether a token is an operation.
     *
     * @param token the token.
     * @return whether the token is + - * /
     */
    private static boolean isOperation(final Token token) {
        switch (token.getType()) {
            case MINUS:
            case PLUS:
            case SLASH:
            case STAR:
                return true;
            default:
                return false;
        }
    }
}
