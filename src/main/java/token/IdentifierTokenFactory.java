package token;

/**
 * A special kind of RegExTokenFactory that produces tokens
 * that are String literals that match the following rule:
 * - First char is a letter (upper/lower case) OR _
 * - Rest of the chars are a letter (upper / lower case) OR a number OR _
 * Both of these rules must be valid.
 */
public class IdentifierTokenFactory extends RegExTokenFactory {

    /**
     * Default constructor.
     */
    public IdentifierTokenFactory() {
        super("\\(?[A-ZA-z_][A-Za-z0-9_]?\\)?");
    }

    @Override
    protected String getTokenText() {
        return super.getTokenText()
                .replace("(", "")
                .replace(")", "");
    }

    @Override
    public Token getToken() {
        return new Token(TokenType.IDENTIFIER, getTokenText(), getTokenLength());
    }
}
