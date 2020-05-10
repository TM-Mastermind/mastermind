package com.mastermind;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Name: ");
//
//        Scanner scanIn = new Scanner(System.in);
//        String inputString = scanIn.nextLine();
//
//        scanIn.close();
//        System.out.println("Name entered : " + inputString);
//        do {
        System.out.println(
                        "+----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "+----+----+----+----+----+" + "\n");

        System.out.println("Enter five colors separated with a space then press enter/return ");
        Scanner scanInGuess = new Scanner(System.in);
        String inputStringGuess = scanInGuess.nextLine();

        scanInGuess.close();
        System.out.println("You entered entered : " + inputStringGuess);

        Map<Integer,String> map = new HashMap<>();
        for(int i = 0; i < 5; i++){
            map.put(i,inputStringGuess.substring(i,i+1));
        }
        Guess guess = new Guess(map);
        Solution sol = new Solution();
        sol.generateColorSequence();
        Hint hint = new Hint();
        hint.generateHint(sol.getColorSequence(),guess.getGuess());
        System.out.println(
                "+----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "|    |    |    |    |    |" + "\n" +
                        "|----+----+----+----+----+" + "\n" +
                        "| " + guess.getGuess().get(0) + " | " + guess.getGuess().get(1) + " | " + guess.getGuess().get(2) + " | " + guess.getGuess().get(3) + " | " + guess.getGuess().get(4) + " |" + "\n" +
                        "+----+----+----+----+----+" + "\n");

//        } while(true);


//SAMPLE CODE CHECKING INITIAL GUESS/SOLUTION AND HINT FUNCTIONALITY
//        Map<Integer,String> map = new HashMap<>();
//        if(args.length != 5){
//            System.out.println("please enter five colors");
//        }
//        else {
//            for (int i = 0; i < 5; i++) {
//                map.put(i, args[i]);
//            }
//        }
//        Guess guess = new Guess(map);
//        Solution sol = new Solution();
//        sol.generateColorSequence();
//        Hint hint = new Hint();
//        hint.generateHint(sol.getColorSequence(),guess.getGuess());
//
        System.out.println("guess " + guess.getGuess());
        System.out.println("sol "+ sol.getColorSequence());
        System.out.println("correct " + hint.getCorrect() + " partial " + hint.getPartialCorrect());
    }
}
