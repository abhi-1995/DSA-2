package com.dsaone.string;

import java.util.Scanner;

public class StringPermutation {

    private static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        }
        for (int i=l; i<=r; i++) {
            str = swap(str,l,i);
            permute(str,l+1,r);
            str = swap(str, l, i);
        }
    }

    private static String swap(String str, int l, int i) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(l, str.charAt(i));
        sb.setCharAt(i, str.charAt(l));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the input string .......................");
        String str = sc.nextLine();

        permute(str, 0, str.length() -1);
    }
}
