package com.mastermind;

import java.security.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Player {
    //-------------Variable
    private String name;
    private int newScanner;

    // -------User input------
    public void permission(){

    }
    public void userInput(){
        List<Integer> hMap= new ArrayList<>();

        System.out.println(" Please Enter you name");
        Scanner userName = new Scanner(System.in);
        String newName= userName.next();
        System.out.println(" Do you want to play MasterMind? press y for play ");
        Scanner permission = new Scanner(System.in);
        String newPermission = permission.next();
        if(newPermission.equals("y")||newPermission.equals("Y")) {

            System.out.println(newName + " Please Enter 5 Number between 1 to 8 ;" +
                    " 1 = B, " +
                    " 2 = BK, " +
                    " 3 = G, " +
                    " 4 = R, " +
                    " 5 = Y, " +
                    " 6 = O, " +
                    " 7 = P," +
                    " 8 =  W");
            Scanner scanner = new Scanner(System.in);
            for (int i = 1; i <= 5; i++) {

                newScanner = scanner.nextInt();
                hMap.add(newScanner);
                if (newScanner < 1 || newScanner > 8) {
                    System.out.println(" Invalid Input range[1-8] ");
                    System.out.println(newName + "Good Bye...........");
                    break;
                }


            }
            System.out.print(hMap+ " ");


    }
        else{
            System.out.println(newName + "Good Bye...........");
        }

        }


//------- Getter and Setter


    public void setName(String name) {
        this.name = name;
    }
}
