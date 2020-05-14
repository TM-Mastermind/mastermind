package com.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HintTest {
    Map<Integer,String> sol = new HashMap<>();
    Guess guess;
    Solution solution = new Solution(5);
    @Before
    public void setUp() {
        sol.put(0,"R");
        sol.put(1,"O");
        sol.put(2,"Y");
        sol.put(3,"R");
        sol.put(4,"G");

        Map<Integer,String> g1 = new HashMap<>();
        g1.put(0,"O");
        g1.put(1,"O");
        g1.put(2,"Y");
        g1.put(3,"R");
        g1.put(4,"R");
        guess = new Guess(g1);
    }

    @Test
    public void shouldGenerateCorrectHint_AndUpdateCorrect() {
        Hint h1 = new Hint(solution);
        h1.generateHint(sol,guess.getGuess());
        assertEquals(3,h1.getCorrect());
    }

    @Test
    public void shouldGeneratePartialCorrect_AndUpdatePartialCorrectField() {
        Hint h1 = new Hint(solution);
        h1.generateHint(sol,guess.getGuess());
        assertEquals(1, h1.getPartialCorrect());
    }
}