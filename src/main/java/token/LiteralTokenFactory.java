package token;

/**
 * A special kind of RegExTokenFactory that produces tokens
 * that are integer literals.
 */
public class LiteralTokenFactory extends RegExTokenFactory {

    /**
     * Create a new LiteralTokenFactory.
     */
    public LiteralTokenFactory() {
        // regular expression for an integer literal
        super("[0-9]+");
    }

    @Override
    public Token getToken() {
        return new Token(TokenType.LITERAL, getTokenText(), getTokenStartPosition());
    }

}
