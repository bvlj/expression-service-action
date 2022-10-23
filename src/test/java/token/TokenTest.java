package token;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TokenTest {

    @Test
    public void testLength1() {
        Token t = new Token(TokenType.PLUS, "+", 0);
        Assert.assertEquals(TokenType.PLUS, t.getType());
        Assert.assertEquals("+", t.getText());
        Assert.assertEquals(0, t.getStartPosition());
        Assert.assertEquals(1, t.getEndPosition());
    }

    @Test
    public void testLength2() {
        Token t = new Token(TokenType.IDENTIFIER, "id", 3);
        Assert.assertEquals(TokenType.IDENTIFIER, t.getType());
        Assert.assertEquals("id", t.getText());
        Assert.assertEquals(3, t.getStartPosition());
        Assert.assertEquals(5, t.getEndPosition());
    }

    @Test
    public void testLength3() {
        Token t = new Token(TokenType.LITERAL, "456", 60);
        Assert.assertEquals(TokenType.LITERAL, t.getType());
        Assert.assertEquals("456", t.getText());
        Assert.assertEquals(60, t.getStartPosition());
        Assert.assertEquals(63, t.getEndPosition());
    }

}
