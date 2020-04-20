package nl.hanze.roy.ads.generics;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleComparable {
    public static <E extends Comparable<E>> void shuffle(ArrayList<E> list) {
        Collections.shuffle(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        ShuffleComparable.shuffle(list);

        System.out.println(list);
    }
}