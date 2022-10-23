package nodes.operations;

import nodes.literals.IntLiteral;
import org.junit.Assert;
import org.junit.Test;

public class SubtractionTest {

    @Test
    public void testToString() {
        Subtraction s = new Subtraction(
                new IntLiteral(10),
                new IntLiteral(7)
        );

        Assert.assertEquals("(10-7)", s.toString());
    }

}
