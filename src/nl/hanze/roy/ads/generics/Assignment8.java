package nl.hanze.roy.ads.generics;

import java.util.ArrayList;
import java.util.Collections;

public class Assignment8 {
    public static <E extends Comparable<E>> void shuffle(ArrayList<E> list) {
        Collections.shuffle(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        Assignment8.shuffle(list);

        System.out.println(list);
    }
}