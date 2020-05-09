package com.mastermind;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//SAMPLE CODE CHECKING INITIAL GUESS/SOLUTION AND HINT FUNCTIONALITY
        Map<Integer,String> map = new HashMap<>();
        if(args.length != 5){
            System.out.println("please enter five colors");
        }
        else {
            for (int i = 0; i < 5; i++) {
                map.put(i, args[i]);
            }
        }
        Guess guess = new Guess(map);
        Solution sol = new Solution();
        sol.generateColorSequence();
        Hint hint = new Hint();
        hint.generateHint(sol.getColorSequence(),guess.getGuess());

        System.out.println("guess " + guess.getGuess());
        System.out.println("sol "+ sol.getColorSequence());
        System.out.println("correct " + hint.getCorrect() + " partial " + hint.getPartialCorrect());
    }
}
