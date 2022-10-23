package nodes.operations;

import nodes.literals.IntLiteral;
import org.junit.Assert;
import org.junit.Test;

public class NegationTest {

    @Test
    public void testToString() {
        Negation n = new Negation(new IntLiteral(5));

        Assert.assertEquals("(-5)", n.toString());
    }
}
