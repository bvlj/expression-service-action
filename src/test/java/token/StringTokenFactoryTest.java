package token;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class StringTokenFactoryTest {

    @Test
    public void testMatchOne() {
        StringTokenFactory f = new TestFactory("a");
        f.setText("XXaXX");
        boolean found = f.find(2);
        assertTrue(found);
        Assert.assertEquals(2, f.getTokenStartPosition());
        Assert.assertEquals(1, f.getTokenLength());
        Assert.assertEquals("a", f.getTokenText());
    }

    @Test
    public void testMatchTwo() {
        StringTokenFactory f = new TestFactory("ha");
        f.setText("XhaX");
        boolean found = f.find(1);
        assertTrue(found);
        Assert.assertEquals(1, f.getTokenStartPosition());
        Assert.assertEquals(2, f.getTokenLength());
        Assert.assertEquals("ha", f.getTokenText());
    }

    @Test
    public void testMatchThereAndNotEarlier() {
        StringTokenFactory f = new TestFactory("hi");
        f.setText("XhiXhiX");
        boolean found = f.find(4);
        assertTrue(found);
        Assert.assertEquals(4, f.getTokenStartPosition());
    }

    @Test
    public void testMatchThereAndNotLater() {
        StringTokenFactory f = new TestFactory("hi");
        f.setText("XhiXhiX");
        boolean found = f.find(1);
        assertTrue(found);
        Assert.assertEquals(1, f.getTokenStartPosition());
    }

    @Test
    public void testNoMatchNowhere() {
        StringTokenFactory f = new TestFactory("hi");
        f.setText("abc");
        assertFalse(f.find(0));
        assertFalse(f.find(1));
        assertFalse(f.find(2));
    }

    @Test
    public void testStartOutOfBounds() {
        StringTokenFactory f = new TestFactory("hi");
        f.setText("abc");
        assertFalse(f.find(4)); // this call does not throw an IOOB exception
    }

    private static final class TestFactory extends StringTokenFactory {
        TestFactory(String tokenText) {
            super(tokenText);
        }

        @Override
        public Token getToken() {
            return null;
        }
    }

}
