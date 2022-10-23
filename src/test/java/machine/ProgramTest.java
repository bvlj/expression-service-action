package machine;

import instructions.integers.*;
import org.junit.Assert;
import org.junit.Test;

public class ProgramTest {

    @Test
    public void testBIPUSH() {
        Program p = new Program();
        p.append(new BIPUSH(1));
        Assert.assertEquals(1, (int) p.execute(Integer.class));
        Assert.assertEquals("  BIPUSH 1\n", p.toString());
    }

    @Test
    public void testINEG() {
        Program p = new Program();
        p.append(new BIPUSH(1));
        p.append(new INEG());
        Assert.assertEquals(-1, (int) p.execute(Integer.class));
        Assert.assertEquals("  BIPUSH 1\n  INEG\n", p.toString());
    }

    @Test
    public void testIADD() {
        Program p = new Program();
        p.append(new BIPUSH(1));
        p.append(new BIPUSH(2));
        p.append(new IADD());
        Assert.assertEquals(3, (int) p.execute(Integer.class));
        Assert.assertEquals("  BIPUSH 1\n  BIPUSH 2\n  IADD\n", p.toString());
    }

    @Test
    public void testISUB() {
        Program p = new Program();
        p.append(new BIPUSH(1));
        p.append(new BIPUSH(2));
        p.append(new ISUB());
        Assert.assertEquals(-1, (int) p.execute(Integer.class));
        Assert.assertEquals("  BIPUSH 1\n  BIPUSH 2\n  ISUB\n", p.toString());
    }

    @Test
    public void testIMUL() {
        Program p = new Program();
        p.append(new BIPUSH(4));
        p.append(new BIPUSH(3));
        p.append(new IMUL());
        Assert.assertEquals(12, (int) p.execute(Integer.class));
        Assert.assertEquals("  BIPUSH 4\n  BIPUSH 3\n  IMUL\n", p.toString());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testOutCrash() {
        Program p = new Program();
        p.append(new BIPUSH(0));
        p.append(new BIPUSH(1));
        p.append(new BIPUSH(2));
        p.append(new BIPUSH(3));
        p.append(new BIPUSH(4));
        p.append(new BIPUSH(5));
        p.append(new BIPUSH(6));
        p.append(new BIPUSH(7));
        p.append(new BIPUSH(8));
        p.append(new BIPUSH(9));
        p.append(new BIPUSH(10));
        // Out of bound array
        p.execute(Integer.class);
    }
}
