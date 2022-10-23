package lang;

import static org.junit.Assert.*;

import org.junit.Test;


public class EvaluatorTest {
    
    @Test
    public void test() {
        int actualResult = new Evaluator().evaluate("1+2-3");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
    
}
