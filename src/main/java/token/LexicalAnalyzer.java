package token;

import java.util.Arrays;

/**
 * A LexicalAnalyzer breaks a String into Tokens.
 * This class supports looking ahead by one token.Token
 * (that token.Token can be put back with putBackToken()):
 *
 * <pre>
 * lexer.fetchNextToken();
 * token.Token t1 = lexer.getCurrentToken();
 * </pre>
 */
public class LexicalAnalyzer {

    private Token token;
    private Token previousToken;
    private String text;
    private int position;
    private TokenFactory[] tokenFactories;


    /**
     * Create an analyzer for the given text,
     * using the given factories to recognize and create tokens.
     *
     * @param expression The text to analyze
     * @param factories  The token factories to use
     */
    public LexicalAnalyzer(final String expression, final TokenFactory[] factories) {
        tokenFactories = Arrays.copyOf(factories, factories.length);
        setText(expression);
    }

    /**
     * Create an analyzer for the given text.
     *
     * @param expression The text to analyze
     */
    public LexicalAnalyzer(final String expression) {
        this(expression, new TokenFactory[]{
                new IdentifierTokenFactory(),
                new LiteralTokenFactory(),
                new OperatorTokenFactory("+", TokenType.PLUS),
                new OperatorTokenFactory("-", TokenType.MINUS),
                new OperatorTokenFactory("*", TokenType.STAR),
                new OperatorTokenFactory("/", TokenType.SLASH),
                new OperatorTokenFactory("%", TokenType.PERCENT),
                new OperatorTokenFactory("^", TokenType.POWER),
                new OperatorTokenFactory("(", TokenType.OPEN_PAREN),
                new OperatorTokenFactory(")", TokenType.CLOSED_PAREN),
        });
    }

    /**
     * Provide a new text to analyze.
     *
     * @param expression The text to analyze
     */
    public void setText(final String expression) {
        token = null;
        previousToken = null;
        text = expression;
        position = 0;
        for (final TokenFactory factory : tokenFactories) {
            factory.setText(expression);
        }
    }

    /**
     * Ask the analyzer to move to the next token in the text.
     */
    public void fetchNextToken() {
        previousToken = token;
        token = scanToken();
    }

    /**
     * Scan the text and extract the next token.
     *
     * @return the next token
     */
    private Token scanToken() {
        if (position == text.length()) {
            return new Token(TokenType.END_OF_FILE, "", position);
        } else {
            int maxLength = 0;
            TokenFactory factoryWithLongestMatch = null;

            for (TokenFactory factory : tokenFactories) {
                if (factory.find(position) && factory.getTokenLength() > maxLength) {
                    maxLength = factory.getTokenLength();
                    factoryWithLongestMatch = factory;
                }
            }

            if (factoryWithLongestMatch == null) {
                return null;
            } else {
                position += factoryWithLongestMatch.getTokenLength();
                return factoryWithLongestMatch.getToken();
            }
        }
    }

    /**
     * Get the current token.
     *
     * @return the current token
     */
    public Token getCurrentToken() {
        return token;
    }

    /**
     * Move back to the previous token.
     * You can only move back one token
     * (and then you need to again call fetchNextToken()).
     * This method allows so-called "one token look-ahead":
     * <code>
     * lex.fetchNextToken();
     * token.Token t1 = lex.getCurrentToken();
     * lex.fetchNextToken();
     * token.Token t2 = lex.getCurrentToken();
     * // look at t2
     * // oops, we didn't actually want to consume t2 yet
     * lex.putBackToken();
     * </code>
     */
    public void putBackToken() {
        token = previousToken;
        previousToken = null;
    }

}
