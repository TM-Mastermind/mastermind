package com.mastermind;

import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import static org.junit.Assert.*;

public class SolutionTest {
    Solution sol;

    @Before
    public void setUp() throws Exception {
        sol = new Solution(4);
    }

    @Test
    public void shouldGenerateSolutionWithSpecifiedSize() {
        sol.generateColorSequence();
        assertEquals(4, sol.getColorSequence().size());
    }

    @Test
    public void shouldContainOnlySelectedCharacters() {
        sol.generateColorSequence();
        assertTrue(sol.getColorSequence().containsValue("\\[A-Z]\\"));//how to do the regex???
    }
}
//"\\[R,O,Y.G,B,P,S]\\"));
//"\\[R|O|Y|G|B|P|S]\\"