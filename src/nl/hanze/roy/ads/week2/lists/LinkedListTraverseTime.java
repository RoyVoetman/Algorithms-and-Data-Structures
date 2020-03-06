package nl.hanze.roy.ads.week2.lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTraverseTime {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Integer number;

        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();

        Iterator<Integer> it = list.iterator();

        while(it.hasNext()) {
            number = it.next();
        }

        System.out.println("Traverse time get method: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            number = list.get(i);
        }

        System.out.println("Traverse time get method: " + (System.nanoTime() - startTime));
    }
}
