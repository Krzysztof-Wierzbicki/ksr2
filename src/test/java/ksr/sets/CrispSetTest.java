package ksr.sets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrispSetTest {

    @Test
    @DisplayName("Basic intersection test")
    void intersection() {
        CrispSet<Integer> set1 = new CrispSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        CrispSet<Integer> set2 = new CrispSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        CrispSet<Integer> intersection = CrispSet.intersection(set1, set2);
        assertFalse(intersection.contains(1));
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(3));
        assertFalse(intersection.contains(4));
    }

    @Test
    @DisplayName("Basic sum test")
    void sum() {
        CrispSet<Integer> set1 = new CrispSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        CrispSet<Integer> set2 = new CrispSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        CrispSet<Integer> intersection = CrispSet.sum(set1, set2);
        assertTrue(intersection.contains(1));
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(3));
        assertTrue(intersection.contains(4));
    }
}