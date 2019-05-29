package ksr.sets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuzzySetTest {

    @Test
    @DisplayName("Basic intersection test")
    void intersection() {
        FuzzySet<Integer> set1 = new FuzzySet<>();
        set1.add(1, 0.1);
        set1.add(2, 0.2);
        set1.add(3, 0.3);
        FuzzySet<Integer> set2 = new FuzzySet<>();
        set2.add(2, 0.4);
        set2.add(3, 0.5);
        set2.add(4, 0.6);

        FuzzySet<Integer> intersection = FuzzySet.intersection(set1, set2);
        assertEquals(0, intersection.contains(1));
        assertEquals(0.2, intersection.contains(2));
        assertEquals(0.3, intersection.contains(3));
        assertEquals(0, intersection.contains(4));
    }

    @Test
    @DisplayName("Basic sum test")
    void sum() {
        FuzzySet<Integer> set1 = new FuzzySet<>();
        set1.add(1, 0.1);
        set1.add(2, 0.2);
        set1.add(3, 0.3);
        FuzzySet<Integer> set2 = new FuzzySet<>();
        set2.add(2, 0.4);
        set2.add(3, 0.5);
        set2.add(4, 0.6);

        FuzzySet<Integer> intersection = FuzzySet.sum(set1, set2);
        assertEquals(0.1, intersection.contains(1));
        assertEquals(0.4, intersection.contains(2));
        assertEquals(0.5, intersection.contains(3));
        assertEquals(0.6, intersection.contains(4));
    }
}