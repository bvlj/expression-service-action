package token;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class LexicalAnalyzerTest {

    @Test
    public void testInitial() {
        final LexicalAnalyzer l = new LexicalAnalyzer("");
        assertNull(l.getCurrentToken());
    }

    @Test
    public void testEof() {
        final LexicalAnalyzer l = new LexicalAnalyzer("");
        l.fetchNextToken();
        Token t = l.getCurrentToken();
        Assert.assertEquals(TokenType.END_OF_FILE, t.getType());
        Assert.assertEquals(0, t.getStartPosition());
    }

    @Test
    public void testEofNextEof() {
        final LexicalAnalyzer l = new LexicalAnalyzer("");
        l.fetchNextToken();
        l.fetchNextToken();
        Token t = l.getCurrentToken();
        Assert.assertEquals(TokenType.END_OF_FILE, t.getType());
        Assert.assertEquals(0, t.getStartPosition());
    }

    @Test
    public void testOne() {
        final LexicalAnalyzer l = new LexicalAnalyzer("+");
        l.fetchNextToken();
        Token t0 = l.getCurrentToken();
        Assert.assertEquals(TokenType.PLUS, t0.getType());
        Assert.assertEquals(0, t0.getStartPosition());
        l.fetchNextToken();
        Token t1 = l.getCurrentToken();
        Assert.assertEquals(TokenType.END_OF_FILE, t1.getType());
        Assert.assertEquals(1, t1.getStartPosition());
    }

    @Test
    public void testTwo() {
        final LexicalAnalyzer l = new LexicalAnalyzer("++");
        l.fetchNextToken();
        Token t = l.getCurrentToken();
        Assert.assertEquals(TokenType.PLUS, t.getType());
        Assert.assertEquals(0, t.getStartPosition());
        l.fetchNextToken();
        t = l.getCurrentToken();
        Assert.assertEquals(TokenType.PLUS, t.getType());
        Assert.assertEquals(1, t.getStartPosition());
        l.fetchNextToken();
        t = l.getCurrentToken();
        Assert.assertEquals(TokenType.END_OF_FILE, t.getType());
        Assert.assertEquals(2, t.getStartPosition());
    }

    @Test
    public void testThree() {
        final LexicalAnalyzer l = new LexicalAnalyzer("(123)");
        l.fetchNextToken();
        Token t = l.getCurrentToken();
        Assert.assertEquals(TokenType.OPEN_PAREN, t.getType());
        Assert.assertEquals(0, t.getStartPosition());
        l.fetchNextToken();
        t = l.getCurrentToken();
        Assert.assertEquals(TokenType.LITERAL, t.getType());
        Assert.assertEquals(1, t.getStartPosition());
        l.fetchNextToken();
        t = l.getCurrentToken();
        Assert.assertEquals(TokenType.CLOSED_PAREN, t.getType());
        Assert.assertEquals(4, t.getStartPosition());
        l.fetchNextToken();
        t = l.getCurrentToken();
        Assert.assertEquals(TokenType.END_OF_FILE, t.getType());
        Assert.assertEquals(5, t.getStartPosition());
    }

    @Test
    public void testIllegalToken() {
        final LexicalAnalyzer l = new LexicalAnalyzer("~");
        l.fetchNextToken();
        Token t = l.getCurrentToken();
        assertNull(t);
    }

    @Test
    public void testLongestFoundToken() {
        final LexicalAnalyzer l = new LexicalAnalyzer("++", new TokenFactory[]{
                new OperatorTokenFactory("++", TokenType.STAR),
                new OperatorTokenFactory("+", TokenType.PLUS)
        });
        l.fetchNextToken();
        Token t = l.getCurrentToken();
        Assert.assertEquals(TokenType.STAR, t.getType());
        Assert.assertEquals("++", t.getText());
    }

}
