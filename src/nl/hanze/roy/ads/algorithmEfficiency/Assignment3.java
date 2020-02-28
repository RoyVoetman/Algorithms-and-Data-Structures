package nl.hanze.roy.ads.algorithmEfficiency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Search for longest sequence of the same number
 *
 * Algorithm efficiency O(n)
 */
public class Assignment3 {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a series of numbers ending with 0: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        String[] segments = string.split(" ");

        int[] askedInts = Stream.of(segments)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] resultV = sameNumber(askedInts);

        System.out.println("The longest same number sequence starts at index " + resultV[0] + " with " + resultV[1] + " values of " + resultV[2]);
    }

    public static int[] sameNumber(int[] askedInts) {
        int longestStart = -1;
        int longestLength = -1;
        int longestValue = -1;

        int currentStart = 0;
        int currentValue = 0;
        boolean foundSequence = false;

        for (int i = 1; i < askedInts.length; i++) {
            if(askedInts[i - 1] == askedInts[i]) {
                if(currentStart == 0) {
                    currentValue = askedInts[i];
                    currentStart = i - 1;
                    foundSequence = true;
                }
            } else {
                if(foundSequence) {
                    foundSequence = false;

                    if(i - currentStart > longestLength) {
                        longestLength = i - currentStart;
                        longestValue = currentValue;
                        longestStart = currentStart;
                    }
                }

                currentStart = 0;
                currentValue = 0;
            }
        }

        // No sequence found, default to first number
        if(longestStart == -1) {
            longestStart = 0;
            longestLength = 1;
            longestValue = askedInts[0];
        }

        return new int[]{longestStart, longestLength, longestValue};
    }
}