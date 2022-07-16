package com.dsaone.string;

import java.util.Scanner;

public class StringPowerset {

    private static void powerset(String str, int i, String curr) {
        if (i == str.length()) {
            System.out.println(curr);
            return;
        }
        powerset(str, i+1, curr + str.charAt(i));
        powerset(str, i+1, curr);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter input string .......................");
        String str = sc.nextLine();

        powerset(str,0,"");
    }
}
