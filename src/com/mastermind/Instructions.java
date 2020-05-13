package com.mastermind;

import java.util.Scanner;

public class Instructions {
    public String msg = "The game randomly chooses colors in a sequence which is hidden from the Player.\n" +
            "The object of the game is to match the same colors in the same ordered sequence,\n" +
            "compared to the hidden solution. You will have a maximum of 12 tries to match the sequence.\n" +
            "After the end of the every trial the game will provide feedback through the below symbols \n\n" +
            "     + (plus) = If Player guess(color) match with Computer color and in the same sequence \n" +
            "     - (minus) = If Player guess(color) match with Computer color but NOT the same oder\n\n";

    public Instructions() {
        System.out.println("New to Game? Need Instructions to play?, Press H or h,\n" +
                " If you do not need help, press any other key to continue...");
        Scanner sc = new Scanner(System.in);
        String help = sc.next();
        if (help.equals("h") || help.equals("H")) {
            System.out.println(getMsg());
        }
    }
    public String getMsg() {
        return msg;
    }
}
