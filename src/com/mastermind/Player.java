package com.mastermind;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Player {
    private String name = "Player1";
    private List<Guess> guess = new ArrayList<>();
    private List<Hint> hint = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void makeGuess(Solution solution) {
        System.out.println("Enter five colors then press enter/return ");
        Scanner scanInGuess = new Scanner(System.in);
        String inputStringGuess = scanInGuess.nextLine();
        System.out.println("You entered entered : " + inputStringGuess);
        Map<Integer,String> map = new HashMap<>();
        for(int i = 0; i < 5; i++){
            map.put(i,inputStringGuess.substring(i,i+1));
        }
        Guess guess = new Guess(map);
        setGuess(guess);
        Hint hint = new Hint();
        hint.generateHint(solution.getColorSequence(),guess.getGuess());
        setHint(hint);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Guess> getGuess() {
        return guess;
    }

    public void setGuess(Guess guess) {
        this.guess.add(guess);
    }

    public List<Hint> getHint() {
        return hint;
    }

    public void setHint(Hint hint) {
        this.hint.add(hint);
    }
}
