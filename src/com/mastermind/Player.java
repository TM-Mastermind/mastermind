package com.mastermind;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class Player {
    private String name;
    private List<Guess> playerGuess = new ArrayList<>();
    private List<Hint> hint = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Player(){
        System.out.println("Please enter your name:");
        name = sc.nextLine();
    }

    public void makeGuess(Solution solution) {
        System.out.println("Please choose from these colors:  [R]ed,[O]range,[Y]ellow,[G]reen,[B]black,[P]urple,[W]hite,[S]ilver ");
        String inputGuess = sc.nextLine().toUpperCase().trim();
        inputGuess = inputGuess.replace(" ", "");

        Map<Integer,String> map = new HashMap<>();
        for(int i = 0; i < inputGuess.length(); i++){
            map.put(i,inputGuess.substring(i,i+1));
        }
        Guess guess = new Guess(map);
        setPlayerGuess(guess);
        Hint hint = new Hint(solution);
        hint.generateHint(solution.getColorSequence(),guess.getGuess());
        setHint(hint);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Guess> getPlayerGuess() {
        return playerGuess;
    }

    public void setPlayerGuess(Guess guess) {
        this.playerGuess.add(guess);
    }

    public List<Hint> getHint() {
        return hint;
    }

    public void setHint(Hint hint) {
        this.hint.add(hint);
    }
}
