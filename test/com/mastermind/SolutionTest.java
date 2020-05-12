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
    public void shouldGenerateSolutionWithRandomColors() {
        sol.generateColorSequence();
        assertEquals(4, sol.getColorSequence().size());
    }
}
//"\\[R,O,Y.G,B,P,S]\\"));