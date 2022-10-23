package nodes.util;

import instructions.cast.D2I;
import machine.Program;
import nodes.Node;
import nodes.Type;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class BinaryOperationsUtilsTest {

    @Test
    public void testDetermineNull() {
        Assert.assertEquals(Type.INVALID, BinaryOperationsUtils.determine(
                new TestNode(Type.INT),
                new TestNode(Type.INVALID)
        ));

        Assert.assertEquals(Type.INVALID, BinaryOperationsUtils.determine(
                new TestNode(Type.INVALID),
                new TestNode(Type.INT)
        ));

        Assert.assertEquals(Type.INVALID, BinaryOperationsUtils.determine(
                new TestNode(Type.INVALID),
                new TestNode(Type.DOUBLE)
        ));

        Assert.assertEquals(Type.INVALID, BinaryOperationsUtils.determine(
                new TestNode(Type.DOUBLE),
                new TestNode(Type.INVALID)
        ));

        Assert.assertEquals(Type.INVALID, BinaryOperationsUtils.determine(
                new TestNode(Type.INVALID),
                new TestNode(Type.INVALID)
        ));
    }

    @Test
    public void testDetermineDouble() {
        Assert.assertEquals(Type.DOUBLE, BinaryOperationsUtils.determine(
                new TestNode(Type.INT),
                new TestNode(Type.DOUBLE)
        ));

        Assert.assertEquals(Type.DOUBLE, BinaryOperationsUtils.determine(
                new TestNode(Type.DOUBLE),
                new TestNode(Type.INT)
        ));

        Assert.assertEquals(Type.DOUBLE, BinaryOperationsUtils.determine(
                new TestNode(Type.DOUBLE),
                new TestNode(Type.DOUBLE)
        ));

    }

    @Test
    public void testDetermineInt() {
        Assert.assertEquals(Type.INT, BinaryOperationsUtils.determine(
                new TestNode(Type.INT),
                new TestNode(Type.INT)
        ));
    }


    @Test
    public void testAddCastingInvalid() {
        Assert.assertEquals(Type.INVALID, BinaryOperationsUtils.addCasting(
                new Program(),
                new TestNode(Type.INVALID),
                new TestNode(Type.INT)
        ));

    }

    @Test
    public void testAddCastingDouble() {
        Program p = new Program();
        Assert.assertEquals(Type.DOUBLE, BinaryOperationsUtils.addCasting(
                p,
                new TestNode(Type.DOUBLE),
                new TestNode(Type.INT)
        ));

        Assert.assertEquals("  I2D\n", p.toString());
    }

    @Test
    public void testAddCastingDInt() {
        Class<BinaryOperationsUtils> clazz = BinaryOperationsUtils.class;

        try {
            Method m = clazz.getDeclaredMethod("castTo", Node.class, Type.class);
            m.setAccessible(true);
            Object i = m.invoke(null, new TestNode(Type.DOUBLE), Type.INT);
            m.setAccessible(false);

            Assert.assertTrue(i instanceof D2I);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static final class TestNode extends Node {

        private final Type type;

        TestNode(final Type type) {
            this.type = type;
        }

        @Override
        public Type getType() {
            return type;
        }

        @Override
        public boolean isConstant() {
            return true;
        }

        @Override
        public void compile(Program p) {
        }
    }
}
