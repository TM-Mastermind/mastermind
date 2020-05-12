package com.mastermind;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Map;
import java.util.Scanner;

public class Game {
    boolean isWinner;
    private Solution solution;


    public void start(){
        GameBoard g1 = new GameBoard(1,5);
        Solution sol = new Solution();
        setSolution(sol);
        solution.generateColorSequence();
        System.out.println("Name: ");
        Scanner scanIn = new Scanner(System.in);
        String inputString = scanIn.nextLine();
        Player p1 = new Player(inputString);
        System.out.println("Welcome " + p1.getName() + ", get ready to play Mastermind");
        g1.setPlayer(p1);
        System.out.println(solution.getColorSequence()); //**Uncomment to check solution at Start


        for(int i = 0; i < 3; i++){
            p1.makeGuess(getSolution());
            g1.generateBoard(p1.getGuess().get(i));
//            System.out.println(p1.getGuess().get(i).getGuess());
//            System.out.println(solution.getColorSequence());
            if(p1.getGuess().get(i).getGuess().equals(solution.getColorSequence())) {
                setWinner(true);
            }
            if(isWinner){
                System.out.println("Great job " + p1.getName() + " YOU WIN!!");
                break;
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
}
