package com.dsaone.string;


import java.util.Scanner;
import java.util.HashMap;


public class PalindromePermutation {
    private static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if (cs > ts) {
            //generating other half reverse string
            StringBuilder sb = new StringBuilder(asf);
            String res = asf;
            if (oddc != null) {
                res += oddc;
            }
            res += sb.reverse().toString();
            System.out.println(res);
            return;
        }
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter the input string .......................");
        String str = scn.nextLine();
        // Contains frequency of each character
        HashMap<Character, Integer> fmap = new HashMap<>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(fmap.containsKey(ch)) {
                int of = fmap.get(ch);
                fmap.put(ch, of + 1);
            } else {
                fmap.put(ch,1);
            }
        }

        Character odd = null; // Contains odd character
        int odds = 0; // Contains number of odd character
        int len = 0; // length of the string to process (generally half the actual length)

        for(Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq % 2 == 1) {
                odd = ch;
                odds++;
            }
            fmap.put(ch, freq/2); // reduce the frequency by 2 of each character
            len += freq/2;
        }
        //If more than one odd character present then palindrome not possible
        if (odds > 1) {
            System.out.println(-1);
            return;
        }
        generatepw(1, len, fmap, odd, "");
    }
}
