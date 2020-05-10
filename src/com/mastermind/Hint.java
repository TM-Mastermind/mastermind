package com.mastermind;

import java.util.List;
import java.util.Map;

public class Hint {
    private int correct;
    private int partialCorrect;

    public void generateHint(Map<Integer,String> solution, Map<Integer,String> guess) {
        int corCounter = 0;
        int parCounter = 0;
        Map<Integer,String> tempGuess = guess;
        Map<Integer,String> tempSolution = solution;

        for(int i = 0; i < 5; i++){
            if(tempSolution.get(i).equals(tempGuess.get(i))) {
                corCounter++;
                tempGuess.put(i,"correct");
                tempSolution.put(i, "checkedCorrect");
            }
        }
        for(int i = 0; i < 5; i++) {
            if(tempSolution.containsValue(tempGuess.get(i))) {
                //add a second for loop to find the key that matches? ugh! it will work but...
                for(int j = 0; j < 5; j++) {
                    if(tempSolution.get(j).equals(tempGuess.get(i))) {
                        parCounter++;
                        tempSolution.put(j,"checked");
                        tempSolution.put(i, "checkedPartial");
                    }
                }
            }
        }
        setCorrect(corCounter);
        setPartialCorrect(parCounter);
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
