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
        System.out.println( "Welcome to Mastermind " + player.getName() + ".  Are you new to the game? Do you need instructions on how to play?, Press H or h for Help.\nIf you do not need help press any other key to continue...");

        Scanner sc = new Scanner(System.in);
        String help=  sc.next();
        if(help.contains("h")||help.equals("H")){
            System.out.println( "The game randomly chooses colors in a sequence which is hidden from the Player.\n" +
                    "The object of the game is to match the same colors in the same ordered sequence,\n" +
                    "compared to the hidden solution. You will have a maximum of 12 tries to match the sequence.\n" +
                    "After the end of the every trial the game will provide feedback through the below symbols: \n\n" +
                    "     + (plus) = If Player guess(color) matches with the solution color and in the same sequence. \n" +
                    "     - (minus) = If Player guess(color) matches with the solution color but NOT the same sequence.\n\n");}

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
