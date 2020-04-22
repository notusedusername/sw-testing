package pti.gyak;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testResult() {
        assertEquals(6.0, (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getResult());
        assertEquals(4.0, (new Calculator()).enter(5).enter(Operation.SUBSTRACT).enter(1).getResult());
        assertEquals(3.0, (new Calculator()).enter(6).enter(Operation.DIVIDE).enter(2).getResult());
        assertEquals(Double.POSITIVE_INFINITY, (new Calculator()).enter(6).enter(Operation.DIVIDE).enter(0).getResult());
        assertEquals(Double.NEGATIVE_INFINITY, (new Calculator()).enter(-6).enter(Operation.DIVIDE).enter(0).getResult());
        assertEquals(12.0, (new Calculator()).enter(6).enter(Operation.MULTIPLY).enter(2).getResult());
        assertEquals(2.0, (new Calculator()).enter(6).enter(Operation.REMAINDER).enter(4).getResult());
        assertEquals(8.0, (new Calculator()).enter(2).enter(Operation.POWER).enter(3).getResult());
        assertEquals(2.0, (new Calculator()).enter(4).enter(Operation.SQRT).getResult());
        assertEquals(0, (new Calculator()).enter(6).enter(Operation.CLEAR).getResult());
    }

    @Test
    public void testHistory() {
        assertEquals("5 + 1 = 6", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getHistory());
        assertEquals("5 / 2 = 2.5", (new Calculator()).enter(5).enter(Operation.DIVIDE).enter(2).getHistory());
        assertEquals("5 + 1 + 1 = 7", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).enter(Operation.ADD).enter(1).getHistory());
        assertEquals(" = 0", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).enter(Operation.CLEAR).getHistory());
        assertEquals(" = 0", (new Calculator()).getHistory());
    }

    @Test
    public void testExpression(){
        assertEquals("5 + 1", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getExpression());
        assertEquals("", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).enter(Operation.CLEAR).getExpression());
    }
}