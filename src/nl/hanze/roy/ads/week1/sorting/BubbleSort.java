package nl.hanze.roy.ads.week1.sorting;

import java.util.Comparator;

public class BubbleSort {
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        int loop = list.length-1;
        boolean swapped;

        for (int i = 0; i < loop; i++) {
            swapped = false;

            for (int j = 0; j < loop; j++) {
                if (list[j].compareTo(list[j+1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;

                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        int loop = list.length-1;
        boolean swapped;

        for (int i = 0; i < loop; i++) {
            swapped = false;

            for (int j = 0; j < loop; j++) {
                if (comparator.compare(list[j], list[j+1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;

                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Digit[] list1 = new Digit[]{new Digit(3),new Digit(5),new Digit(2),new Digit(2),new Digit(1),new Digit(4),new Digit(7)};
        Digit[] list2= new Digit[]{new Digit(3),new Digit(5),new Digit(2),new Digit(2),new Digit(1),new Digit(4),new Digit(7)};

        bubbleSort(list1);

        System.out.println("List 1");
        for (Digit digit : list1) {
            System.out.print(digit + ", ");
        }
    }
}
