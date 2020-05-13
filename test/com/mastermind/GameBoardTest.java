package com.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GameBoardTest {
    GameBoard gb;
    Guess guess;
    Map<Integer, String> map = new HashMap<>();
    Hint hint;
    Solution sol = new Solution(4);
    @Before
    public void setUp() throws Exception {
        gb = new GameBoard(sol);
        map.put(0,"R");
        map.put(1,"O");
        map.put(2,"Y");
        map.put(3,"G");
        map.put(4,"B");
        guess = new Guess(map);
        hint = new Hint(sol);
        hint.setCorrect(2);
        hint.setPartialCorrect(1);

    }

    @Test
    public void shouldGenerateRowsBasedOnNumberOFColumns() {
        gb.generateBoard(guess,hint);
        assertEquals(1,gb.getRowCount());
    }

    @Test
    public void generateHintRow() {
    }

    @Test
    public void generateBoard() {
    }
}