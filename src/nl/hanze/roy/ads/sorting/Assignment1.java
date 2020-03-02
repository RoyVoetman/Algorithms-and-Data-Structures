package nl.hanze.roy.ads.sorting;

import java.util.Comparator;

public class Assignment1 {
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
        bubbleSort(list2);

        System.out.println("List 1");
        for (Digit digit : list1) {
            System.out.print(digit + ", ");
        }

        System.out.println("\nList 2");
        for (Digit digit : list2) {
            System.out.print(digit + ", ");
        }
    }
}

class Digit implements Comparator<Digit>, Comparable<Digit> {
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
