package nodes.operations;

import nodes.literals.IntLiteral;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationTest {

    @Test
    public void testToString() {
        Multiplication m = new Multiplication(
                new IntLiteral(6),
                new IntLiteral(7)
        );

        Assert.assertEquals("(6*7)", m.toString());
    }
}
