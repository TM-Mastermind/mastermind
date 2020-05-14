package com.mastermind;

import java.util.HashMap;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

public class Solution {
   public static final Map<Integer,String> ALL_COLORS = ofEntries(
            entry(1,"R"),
            entry(2,"O"),
            entry(3,"Y"),
            entry(4,"G"),
            entry(5,"B"),
            entry(6,"P"),
            entry(7,"W"),
            entry(8,"S")
    );
   private Map<Integer,String> colorSequence;
   private int length;

    public Solution() {
        Scanner sc = new Scanner(System.in);
        boolean acceptedInput = false;
        while (!acceptedInput) {
            System.out.println("Enter the length of the color sequence 3-9");
            String input = sc.next();
            if (input.matches("[3-9]")) {
                acceptedInput = true;
                int length = Integer.parseInt(input);
                setLength(length);
            }
            else {
                System.err.println("Sorry, invalid input of " + input + ".\n Hint: valid range [3-9] in digit");
            }
        }
    }

   public Solution(int length) {
        this.length = length;
   }

    public void generateColorSequence() {
        Map<Integer,String> colors = new HashMap<>();
        for (int i = 0; i < getLength(); i++) {
            colors.put(i, ALL_COLORS.get(getRandom()));
        }
        setColorSequence(colors);
    }

    public int getRandom() {
        return (int) (1 + Math.floor((Math.random() * 8)));
    }

    // Accessor Methods

    public Map<Integer, String> getColorSequence() {
        return colorSequence;
    }

    public void setColorSequence(Map<Integer, String> colorSequence) {
        this.colorSequence = colorSequence;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
