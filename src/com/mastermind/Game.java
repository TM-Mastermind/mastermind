package com.mastermind;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Map;
import java.util.Scanner;

public class Game {
    boolean isWinner;
    private Solution solution;
    private int rounds = 12;


    public void start(){
        Player p1 = new Player();
        p1.showInstructions();
        System.out.println("Okay " + p1.getName() + ", get ready to play Mastermind");
        Solution sol = new Solution();
        GameBoard g1 = new GameBoard(sol);
        setSolution(sol);
        solution.generateColorSequence();
        g1.setPlayer(p1);
        System.out.println(solution.getColorSequence()); //**Uncomment to check solution at Start

        for(int i = 0; i < getRounds(); i++){
            p1.makeGuess(getSolution());
            g1.generateBoard(p1.getPlayerGuess().get(i), p1.getHint().get(i));
            if(p1.getPlayerGuess().get(i).getGuess().equals(solution.getColorSequence())) {
                setWinner(true);
            }
            if(isWinner){
                System.out.println("Great job " + p1.getName() + " YOU WIN!!");
                break;
            }
            else if(i == getRounds() -1) {
                System.out.println("Sorry " + p1.getName() + " you ran out of guesses. Please try again.");

            }

        }
    }



    //Accessor Methods
    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
