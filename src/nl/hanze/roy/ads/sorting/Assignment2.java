package nl.hanze.roy.ads.sorting;

import java.util.Arrays;

public class Assignment2 {
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length <= 1) {
            return;
        }

        int n = list.length;

        E[] left = Arrays.copyOfRange(list, 0, (n + 1)/2);
        E[] right = Arrays.copyOfRange(list, (n + 1)/2, n);

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    public static <E extends Comparable<E>> void merge(E[] list, E[] left, E[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                list[k++] = left[i++];
            } else {
                list[k++] = right[j++];
            }
        }

        // Only one of these two loops will equally be entered
        while (i < left.length) {
            list[k++] = left[i++];
        }
        while (j < right.length) {
            list[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        Digit[] list1 = new Digit[]{new Digit(3),new Digit(5),new Digit(2),new Digit(2),new Digit(1),new Digit(4),new Digit(7)};

        mergeSort(list1);

        System.out.println("List 1");
        for (Digit digit : list1) {
            System.out.print(digit + ", ");
        }
    }
}
