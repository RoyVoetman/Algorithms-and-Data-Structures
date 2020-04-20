package nl.hanze.roy.ads.sets;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Difference: " + difference(set1, set2));
        System.out.println("Intersaction: " + intersection(set1, set2));
    }

    public static Set<String> union(Set<String> set1, Set<String> set2) {
        Set<String> union = new LinkedHashSet<>();

        union.addAll(set1);
        union.addAll(set2);

        return union;
    }

    public static Set<String> difference(Set<String> set1, Set<String> set2) {
        Set<String> union = new LinkedHashSet<>(set1);

        for (String elem1 : set1) {
            for (String elem2 : set2) {
                if(elem1.equals(elem2)) {
                    union.remove(elem1);
                } else {
                    union.add(elem2);
                }
            }
        }

        return union;
    }

    public static Set<String> intersection(Set<String> set1, Set<String> set2) {
        Set<String> union = new LinkedHashSet<>();

        for (String elem1 : set1) {
            for (String elem2 : set2) {
                if(elem1.equals(elem2)) {
                    union.add(elem1);
                    break;
                }
            }
        }

        return union;
    }
}
