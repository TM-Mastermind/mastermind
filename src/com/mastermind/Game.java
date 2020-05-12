package com.mastermind;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Map;
import java.util.Scanner;

public class Game {
    boolean isWinner;
    private Solution solution;
    private int rounds = 12;


    public void start(){
        Solution sol = new Solution();
        GameBoard g1 = new GameBoard(sol);
        setSolution(sol);
        solution.generateColorSequence();
//        System.out.println("Name: ");
//        Scanner scanIn = new Scanner(System.in);
//        String inputString = scanIn.nextLine();
//        Player p1 = new Player(inputString);
        Player p1 = new Player();
        System.out.println("Welcome " + p1.getName() + ", get ready to play Mastermind");
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
