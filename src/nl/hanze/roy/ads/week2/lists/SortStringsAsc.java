package nl.hanze.roy.ads.week2.lists;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortStringsAsc {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        FileInputStream fstream = new FileInputStream("src/nl/hanze/roy/ads/datastructures/words.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fstream))) {
            reader.lines().forEach(list::add);
        }

        Collections.sort(list);

        System.out.println(list);
    }
}
