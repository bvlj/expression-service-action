package nodes.operations;

import nodes.literals.IntLiteral;
import nodes.variables.IntVariable;
import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {

    @Test
    public void testToString() {
        final Addition a = new Addition(
                new IntLiteral(1),
                new Addition(
                        new IntLiteral(4),
                        new IntVariable("x")
                )
        );

        Assert.assertEquals("(1+(4+x))", a.toString());
    }
}
