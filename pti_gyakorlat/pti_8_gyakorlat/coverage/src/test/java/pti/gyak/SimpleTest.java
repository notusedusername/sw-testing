package pti.gyak;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleTest {

    @Test
    public void testBalAg() {
        Simple simple = new Simple();
        assertEquals(354, simple.func(354, 400, 300));
    }

    @Test
    public void testCase2() {
        Simple simple = new Simple();
        assertEquals(-698, simple.func(698, 400, 300));
    }

    @Test
    public void testCase3() {
        Simple simple = new Simple();
        assertEquals(1, simple.func(14, 1, 2));
        assertEquals(2, simple.func(123, 3, 2));
    }


}