package nodes.operations;

import nodes.literals.IntLiteral;
import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {

    @Test
    public void testToString() {
        Division d = new Division(
                new IntLiteral(6),
                new IntLiteral(2)
        );

        Assert.assertEquals("(6/2)", d.toString());
    }
}
