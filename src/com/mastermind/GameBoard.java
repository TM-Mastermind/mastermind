package com.mastermind;

public class GameBoard {
    private StringBuilder rowWithGuess = new StringBuilder();
    private StringBuilder hintForGuess = new StringBuilder();
    private Player player;
    private Solution sol;
    private int rowCount;

    public GameBoard(){
    }

    public GameBoard(Solution solution) {
        sol = solution;
    }

    public int generateRow(Guess guess) {
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
        setRowCount();
        newRow.append("\n    " +rowBase + "\n" + getRowCount() + ".  " + row + "     " + hintForGuess + "\n    " + rowBase);
        rowWithGuess.append("\n" + newRow);

        return getRowCount();
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

    // Accessor Methods

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount() {
        rowCount++;
    }
}
