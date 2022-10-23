package token;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class LiteralTokenFactoryTest {

    @Test
    public void testFoundLength1() {
        LiteralTokenFactory f = new LiteralTokenFactory();
        f.setText("a=9x");
        boolean found = f.find(2);
        assertTrue(found);
        Assert.assertEquals(1, f.getTokenLength());
        Assert.assertEquals(2, f.getTokenStartPosition());
        Assert.assertEquals("9", f.getTokenText());
        Assert.assertEquals(TokenType.LITERAL, f.getToken().getType());
    }

    @Test
    public void testFoundLength3() {
        LiteralTokenFactory f = new LiteralTokenFactory();
        f.setText("abc=123x");
        boolean found = f.find(4);
        assertTrue(found);
        Assert.assertEquals(3, f.getTokenLength());
        Assert.assertEquals(4, f.getTokenStartPosition());
        Assert.assertEquals("123", f.getTokenText());
        Assert.assertEquals(TokenType.LITERAL, f.getToken().getType());
    }

    @Test
    public void testNoMatchNotFound() {
        LiteralTokenFactory f = new LiteralTokenFactory();
        f.setText("abc=xyz");
        boolean found = f.find(4);
        assertFalse(found);
    }

}
