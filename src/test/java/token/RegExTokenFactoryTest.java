package token;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class RegExTokenFactoryTest {

    @Test
    public void testMatchFixed() {
        RegExTokenFactory f = new TestFactory("hi");
        f.setText("XXhiXX");
        boolean found = f.find(2);
        assertTrue(found);
        Assert.assertEquals(2, f.getTokenStartPosition());
        Assert.assertEquals(2, f.getTokenLength());
        Assert.assertEquals("hi", f.getTokenText());
    }

    @Test
    public void testMatchFlexible() {
        RegExTokenFactory f = new TestFactory("ha*");
        f.setText("XhaaaX");
        boolean found = f.find(1);
        assertTrue(found);
        Assert.assertEquals(1, f.getTokenStartPosition());
        Assert.assertEquals(4, f.getTokenLength());
        Assert.assertEquals("haaa", f.getTokenText());
    }

    @Test
    public void testMatchThereAndNotEarlier() {
        RegExTokenFactory f = new TestFactory("hi");
        f.setText("XhiXhiX");
        boolean found = f.find(4);
        assertTrue(found);
        Assert.assertEquals(4, f.getTokenStartPosition());
    }

    @Test
    public void testMatchThereAndNotLater() {
        RegExTokenFactory f = new TestFactory("hi");
        f.setText("XhiXhiX");
        boolean found = f.find(1);
        assertTrue(found);
        Assert.assertEquals(1, f.getTokenStartPosition());
    }

    @Test
    public void testNoMatchNowhere() {
        RegExTokenFactory f = new TestFactory("hi");
        f.setText("abc");
        assertFalse(f.find(0));
        assertFalse(f.find(1));
        assertFalse(f.find(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testStartOutOfBounds() {
        RegExTokenFactory f = new TestFactory("hi");
        f.setText("abc");
        f.find(4); // this call must throw an IOOB exception
    }

    private static final class TestFactory extends RegExTokenFactory {
        TestFactory(String regEx) {
            super(regEx);
        }

        @Override
        public Token getToken() {
            return null;
        }
    }
}
