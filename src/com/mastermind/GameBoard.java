package com.mastermind;

public class GameBoard {
    //private int columns = 3;
    private StringBuilder rowWithGuess = new StringBuilder();
    private StringBuilder hintForGuess = new StringBuilder();
    private Player player;
    private Solution sol;

    public GameBoard(){
    }

    public GameBoard(Solution solution) {
        sol = solution;
    }

    public String generateRow(Guess guess) {
        StringBuilder rowBase = new StringBuilder();
        StringBuilder row = new StringBuilder();
        StringBuilder newRow = new StringBuilder();
        for(int i = 0; i < sol.getLength(); i++){
            if(i == sol.getLength() - 1) {
                if (guess != null) {
                    row.append("|  " + guess.getGuess().get(i) + " |");
                }
                else row.append("|    |");
                rowBase.append("+----+");
            }
            else {
                if (guess != null) {
                    row.append("|  " + guess.getGuess().get(i) + " ");
                }
                else row.append("|    ");
                rowBase.append("+----");
            }
        }
        newRow.append("\n" +rowBase + "\n" + row + "     " + hintForGuess + "\n" + rowBase);
        rowWithGuess.append("\n" + newRow);

        return newRow.toString();
    }

    public void generateHintRow(Hint hint) {
        StringBuilder hintRow = new StringBuilder();
        hintRow.append("| + ".repeat(Math.max(0, hint.getCorrect())));
        hintRow.append("| - ".repeat(Math.max(0, hint.getPartialCorrect())));
        if(hintRow.length() == 0){
            hintRow.append("|  none correct  |");
        }
        else {
            hintRow.append("|");
        }
        hintForGuess.delete(0,hintForGuess.length());
        hintForGuess.append(hintRow);
    }

    public void generateBoard(Guess guess, Hint hint) {
        generateHintRow(hint);
        generateRow(guess);
        String rowBuilder = rowWithGuess.toString();
        System.out.println(rowBuilder);
    }



    public void setPlayer(Player player) {
        this.player = player;
    }
}