package com.mastermind;

import java.util.Scanner;

public class Game {
    boolean isWinner;
    private Solution solution;
    private int rounds = 12;
    private Scanner sc = new Scanner(System.in);
    private Player player;


    public void start() {
        setPlayer(new Player());
        System.out.println( player.getName() + " : , New to Game? Need instructions to play?, Press H or h, or if you do not need help\nPress any other key to continue...");

        Scanner sc = new Scanner(System.in);
        String help=  sc.next();
        if(help.contains("h")||help.equals("H")){
            System.out.println("Computer randomly/secretly chooses colors in sequence which is hidden to player,\nyou have to match same colors in same sequences,\nuntil you matches all colors in same sequence or run out of trial\nAfter end of the every trial computer will provide feed back in below symbol \n\n     + : If player guess(color) match with computer color and in the same sequence\n     - : If player guess(color) match with computer color but NOT in the same order\n");}

        System.out.println("Okay " + player.getName() + ", get ready to play Mastermind\n");
        Solution sol = new Solution();
        sol.generateColorSequence();
        GameBoard g1 = new GameBoard(sol);
        setSolution(sol);

        // System.out.println(solution.getColorSequence()); //**Uncomment to check solution at Start

        for(int i = 0; i < getRounds(); i++){
            player.makeGuess(solution);
            g1.generateBoard(player.getPlayerGuess().get(i), player.getHint().get(i));
            if(player.getPlayerGuess().get(i).getGuess().equals(solution.getColorSequence())) {
                setWinner(true);
            }
            if(isWinner){
                System.out.println("Great job " + player.getName() + " YOU WIN!!");
                break;
            }
            else if(i == getRounds() -1) {
                System.out.println("Sorry " + player.getName() + " you ran out of guesses. Please try again.");

            }

        }
        try {
            Thread.sleep(1500);
            playAgain();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void playAgain() throws InterruptedException {
            System.out.println("Do you want to play again?  Y/N");
            String play = sc.next().toUpperCase();
            if (play.contains("Y")) {
                start();
            } else {
                System.out.println("Thank you for playing, goodbye.");
                Thread.sleep(1500);
                System.exit(0);
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
