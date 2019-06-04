package ksr.sets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void intCompareTo() {
        IntRange range1 = new IntRange(0, 1);
        IntRange range2 = new IntRange(1, 2);
        assertEquals(-1, range1.compareTo(range2));
        assertEquals(1, range2.compareTo(range1));
        assertEquals(0, range1.compareTo(range1));
        assertEquals(0, range2.compareTo(range2));
        range1.set(0, 1);
        range2.set(0, 2);
        assertEquals(0, range1.compareTo(range2));
        assertEquals(0, range2.compareTo(range1));
        range1.set(1, 2);
        range2.set(0, 2);
        assertEquals(0, range1.compareTo(range2));
        assertEquals(0, range2.compareTo(range1));
    }
}