package nl.hanze.roy.ads.algorithm.efficiency;

import java.util.Scanner;

/**
 * Search for longest consecutive substring in a provided string.
 *
 * Algorithm efficiency O(n)
 */
public class Assignment1 {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String string = (new Scanner(System.in)).next();

        System.out.println("Result: " + searchConsecutiveSubstring(string));
    }

    public static String searchConsecutiveSubstring(String s) {
        int longestStart = 0;
        int longestLength = 0;
        int currentStart = 0;
        int currentLength;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars.length == i+1 || chars[i] >= chars[i+1]) {
                currentLength = i+1 - currentStart;
                if(currentLength > longestLength) {
                    longestStart = currentStart;
                    longestLength = currentLength;
                }
                currentStart = i+1;
            }
        }

        return s.substring(longestStart, longestStart+longestLength);
    }
}