package com.mastermind;

import java.util.HashMap;
import java.util.Map;

public class Hint {
    private int correct;
    private int partialCorrect;
    private Solution sol;

    public Hint(){
    }

    public Hint(Solution solution){
        sol = solution;
    }

    public void generateHint(Map<Integer,String> solution, Map<Integer,String> guess) {
        int solLength = sol.getLength();
        int corCounter = 0;
        int parCounter = 0;
        Map<Integer, String> tempGuess = new HashMap<>(guess);
        Map<Integer, String> tempSolution = new HashMap<>(solution);

        for(int i = 0; i < solLength; i++){
            if(tempSolution.get(i).equals(tempGuess.get(i))) {
                corCounter++;
                tempGuess.put(i,"correct");
                tempSolution.put(i, "checkedCorrect");
            }
        }
        for(int i = 0; i < solLength; i++) {
            if(tempSolution.containsValue(tempGuess.get(i))) {
                for(int j = 0; j < solLength; j++) {
                    if(tempSolution.get(j).equals(tempGuess.get(i))) {
                        parCounter++;
                        tempSolution.put(j,"checked");
                        tempGuess.put(i, "checkedPartial");
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
