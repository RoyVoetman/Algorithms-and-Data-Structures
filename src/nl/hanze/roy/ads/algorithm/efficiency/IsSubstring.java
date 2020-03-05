package nl.hanze.roy.ads.algorithm.efficiency;

import java.util.Scanner;

/**
 * Determine if string 2 is a substring of string 1
 *
 * Algorithm efficiency O(n)
 */
public class IsSubstring {
    public static void main(String[] args) {
        System.out.print("Enter string 1: ");
        String string1 = (new Scanner(System.in)).next();
        System.out.print("Enter string 2: ");
        String string2 = (new Scanner(System.in)).next();

        System.out.println("matched at index: " + patternMatching(string1, string2));
    }

    public static int patternMatching(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int patternStart = -1;
        int patternLength = 0;

        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[patternLength]) {
                patternLength = 0;
                continue;
            }

            if(patternLength == 0) {
                patternStart = i;
            }

            patternLength++;

            if(patternLength == chars2.length) {
                break;
            }
        }

        return patternStart;
    }
}