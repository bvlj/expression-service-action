package lang;

import instructions.integers.BIPUSH;
import instructions.integers.IADD;
import instructions.integers.ISUB;
import machine.Program;
import org.junit.Assert;
import org.junit.Test;


public class CompilerTest {

    /*
     * parse term      1
     * parse factor    1
     * -> IntLiteral   1
     * -> Addition     +
     * parse factor    +
     * parse term      2
     * -> IntLiteral   2
     * -> Subtraction  -
     * parse expr      -
     * parse term      3
     * -> IntLiteral   3
     * -> first (^)    3
     */

    @Test
    public void test() {
        Program actualProgram = new Compiler().compile("1+2-3");
        Program expectedProgram = new Program();
        expectedProgram.append(new BIPUSH(1));
        expectedProgram.append(new BIPUSH(2));
        expectedProgram.append(new IADD());
        expectedProgram.append(new BIPUSH(3));
        expectedProgram.append(new ISUB());
        Assert.assertEquals(expectedProgram.toString(), actualProgram.toString());
    }

}
