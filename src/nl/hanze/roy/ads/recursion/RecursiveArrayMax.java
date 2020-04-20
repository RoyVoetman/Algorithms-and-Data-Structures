package nl.hanze.roy.ads.recursion;

import java.util.Arrays;

public class RecursiveArrayMax {
    static int arrayMaxNumber(int[] array) {
        return arrayMaxNumber(array, -1);
    }

    static int arrayMaxNumber(int[] array, int largest) {
        if(array.length == 0) {
            return largest;
        }

        if(largest < array[0]) {
            largest = array[0];
        }

        array = Arrays.copyOfRange(array, 1, array.length);

        return arrayMaxNumber(array, largest);
    }

    public static void main(String[] args) {
        System.out.println("Antwoord: " + arrayMaxNumber(new int[]{3,2,5,4,5,6,7,23,5}));
    }
}