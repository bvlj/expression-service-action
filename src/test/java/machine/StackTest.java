package machine;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test(expected = IllegalAccessException.class)
    public void testHolderCrash() throws IllegalAccessException {
        StackValuesHolder holder = new StackValuesHolder();
        holder.push(1);
        holder.pop(Double.class);
    }

    @Test()
    public void testOperandStackNull() {
        OperandStack stack = new OperandStack();
        stack.push(1);
        Assert.assertNull(stack.pop(Double.class));
    }
}
