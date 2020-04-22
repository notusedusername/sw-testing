package pti.gyak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComplexTest {

    @Test
    public void testBalAg() {
        Complex complex = new Complex();
        assertEquals(354, complex.func(354, 400, 300));
    }

    @Test
    public void test698() {
        Complex complex = new Complex();
        assertEquals(-698, complex.func(698, 400, 300));
    }

    @Test
    public void testSecondGreater() {
        Complex complex = new Complex();
        assertEquals(1, complex.func(699, 1, 300));
    }

    @Test
    public void testThirdGreater() {
        Complex complex = new Complex();
        assertEquals(300, complex.func(699, 1000, 300));
    }

}