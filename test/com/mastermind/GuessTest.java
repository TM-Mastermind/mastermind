package com.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GuessTest {
    Map<Integer,String> map;
    @Before
    public void setUp() {
        List<String> colors = Arrays.asList("R", "O", "G", "Y", "B", "P", "S", "W");
         map = new HashMap<>();
         int counter = 0;
        for(String color : colors) {
            map.put(counter,color);
            counter++;
        }
    }

    @Test
    public void testsSetGuess() {
        Guess guess = new Guess(map);
        assertEquals(8, guess.getGuess().size());
    }
}