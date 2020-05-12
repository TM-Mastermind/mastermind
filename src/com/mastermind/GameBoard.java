package com.mastermind;

public class GameBoard {
    private String[][] board;
    private int rows = 1;
    private int columns = 5;
    private Player player;
    private boolean isWinner = false;
    private Solution solution;
    private StringBuilder rowWithGuess = new StringBuilder();


    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void generateRow(Guess guess) {
        StringBuilder rowBase = new StringBuilder();
        StringBuilder row = new StringBuilder();
        StringBuilder newRow = new StringBuilder();
        for(int i = 0; i < getColumns(); i++){
            if(i == getColumns() - 1) {
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
        newRow.append("\n" +rowBase + "\n" + row + "\n" + rowBase);
        rowWithGuess.append("\n" + newRow);
    }
    public void generateBoard(Guess guess) {
        int counter = 1;
        if(isWinner) {
            System.out.println("you win!!");
        }
        generateRow(guess);

        String rowBuilder = rowWithGuess.toString();
        System.out.println(rowBuilder);
        counter++;
        setRows(counter);
    }


    // Accessor Methods
    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution() {
        this.solution.generateColorSequence();
    }
}
