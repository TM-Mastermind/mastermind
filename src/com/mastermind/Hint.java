package com.mastermind;

import java.util.List;
import java.util.Map;

public class Hint {
    private int correct;
    private int partialCorrect;

    public void generateHint(Map<Integer,String> solution, Map<Integer,String> guess) {
        int black = 0;
        int white = 0;
        for(int i = 0; i < 5; i++){
            if(solution.get(i).equals(guess.get(i))) {
                black++;
                guess.put(i,"correct");
                solution.put(i, "checkedCorrect");
            }
        }
        for(int i = 0; i < 5; i++) {
            if(solution.containsValue(guess.get(i))) {
                //add a second for loop to find the key that matches? ugh! it will work but...
                for(int j = 0; j < 5; j++) {
                    if(solution.get(j).equals(guess.get(i))) {
                        white++;
                        solution.put(j,"checked");
                    }
                }
            }
        }
        setCorrect(black);
        setPartialCorrect(white);
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getPartialCorrect() {
        return partialCorrect;
    }

    public void setPartialCorrect(int partialCorrect) {
        this.partialCorrect = partialCorrect;
    }
}
