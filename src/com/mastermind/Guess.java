package com.mastermind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guess {
    private Map<Integer,String> guess = new HashMap<>(); //do we make a guess factory instead?

    // Constructors
    public Guess(){
    }

    public Guess(Map<Integer,String> guess){
        this.guess = guess;
    }

    // Accessor Methods
    public Map<Integer, String> getGuess() {
        return guess;
    }

    public void setGuess(Map<Integer, String> guess) {
        this.guess = guess;
    }
}
