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

        Player p1 = new Player();
        System.out.println("Welcome " + p1.getName() + ", get ready to play Mastermind");
        g1.setPlayer(p1);
        System.out.println(solution.getColorSequence()); //**Uncomment to check solution at Start
        System.out.println( p1.getName() + " : , New to Game? Need Instructions to play?, Press H or h, If you do not need help\nPress any other key to continue...");

       Scanner sc = new Scanner(System.in);
        String help=  sc.next();
        if(help.contains("h")||help.equals("H")){
            System.out.println("Computer randomly/Secretly chooses  colors in sequence which is hidden to Player,\nyou have to match same colors in same Sequences,\nuntil you matches all colors in same sequence or run out of trial\nAfter end of the every trial Computer will provide feed back in below symbol \n+ : If Player guess(color) match with Computer color and in same Sequence\n- : If Player guess(color) match with Computer color but not same oder   ");}

//         setSolution(p1.setPussleLength());
//
//        GameBoard g1= new GameBoard((sol));
//        setSolution(sol);
//        solution.getColorSequence();
        g1.setPlayer(p1);
        for(int i = 0; i < getRounds(); i++){
            p1.makeGuess(getSolution());//can remove solution arg if it lives in Player
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