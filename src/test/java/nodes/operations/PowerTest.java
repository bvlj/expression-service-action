package nodes.operations;

import nodes.literals.DoubleLiteral;
import nodes.literals.IntLiteral;
import org.junit.Assert;
import org.junit.Test;

public class PowerTest {

    @Test
    public void testToString() {
        Power d = new Power(
                new IntLiteral(2),
                new DoubleLiteral(3.0)
        );

        Assert.assertEquals("(2^3.0)", d.toString());
    }
}
