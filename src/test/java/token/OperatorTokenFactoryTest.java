package token;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class OperatorTokenFactoryTest {

    @Test
    public void testPlusFound() {
        OperatorTokenFactory f = new OperatorTokenFactory("+", TokenType.PLUS);
        f.setText("ab+12");
        boolean found = f.find(2);
        assertTrue(found);
        Assert.assertEquals(2, f.getTokenStartPosition());
        Assert.assertEquals("+", f.getTokenText());
        Assert.assertEquals(1, f.getTokenLength());
        Assert.assertEquals(2, f.getToken().getStartPosition());
        Assert.assertEquals(TokenType.PLUS, f.getToken().getType());
        Assert.assertEquals("+", f.getToken().getText());
    }

    @Test
    public void testPlusNotFound() {
        OperatorTokenFactory f = new OperatorTokenFactory("+", TokenType.PLUS);
        f.setText("ab-12");
        boolean found = f.find(2);
        assertFalse(found);
    }

}
