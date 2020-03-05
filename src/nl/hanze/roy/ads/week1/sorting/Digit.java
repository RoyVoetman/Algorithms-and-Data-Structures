package nl.hanze.roy.ads.week1.sorting;

import java.util.Comparator;

public class Digit implements Comparator<Digit>, Comparable<Digit> {
    int digit;

    public Digit(int digit) {
        this.digit = digit;
    }

    @Override
    public int compareTo(Digit o) {
        return Integer.compare(this.getDigit(), o.getDigit());
    }

    @Override
    public int compare(Digit x, Digit y) {
        return Integer.compare(x.getDigit(), y.getDigit());
    }

    public int getDigit() {
        return digit;
    }

    public String toString() {
        return "" + digit;
    }
}
