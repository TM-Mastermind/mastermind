package com.mastermind;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void shouldGenerateSolutionWithRandomColors() {
        Solution sol = new Solution();
        sol.generateColorSequence();
        assertEquals(5, sol.getColorSequence().size());
    }
}