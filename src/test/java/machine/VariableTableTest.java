package machine;

import org.junit.Assert;
import org.junit.Test;

public class VariableTableTest {

    @Test
    public void testGetNull() {
        VariableTable table = new VariableTable();
        table.set("x", 1);

        Assert.assertNull(table.get("x", Double.class));
    }
}
