package com.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;

public class SolutionTest {
    Solution sol;

    @Before
    public void setUp() {
        List<String> colors = Arrays.asList("R", "O", "G", "Y", "B", "P", "S", "W");
        sol = new Solution(5);
    }

    @Test
    public void shouldGenerateSolutionWithSpecifiedSize() {
        sol.generateColorSequence();
        assertEquals(5, sol.getColorSequence().size());
    }

    @Test
    public void shouldContainOnlySelectedCharacters() {
        sol.generateColorSequence();
        assertTrue(sol.getColorSequence().containsValue("R") || sol.getColorSequence().containsValue("O") ||
                sol.getColorSequence().containsValue("Y") ||sol.getColorSequence().containsValue("G") ||
                sol.getColorSequence().containsValue("B") || sol.getColorSequence().containsValue("P") ||
                sol.getColorSequence().containsValue("S") || sol.getColorSequence().containsValue("W"));
    }
}