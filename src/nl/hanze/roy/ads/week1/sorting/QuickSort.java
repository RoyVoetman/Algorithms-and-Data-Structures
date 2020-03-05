package nl.hanze.roy.ads.week1.sorting;

public class QuickSort {
    public static <E extends Comparable<E>> void quickSort(E[] list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
    }

    public static <E extends Comparable<E>> int partition(E[] list, int low, int high) {
        E pivot = list[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (list[j].compareTo(pivot) < 0) {
                swap(list, i, j);
                i++;
            }
        }

        swap(list, i, high);

        return i;
    }

    public static <E extends Comparable<E>> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        Digit[] list1 = new Digit[]{new Digit(3),new Digit(5),new Digit(2),new Digit(2),new Digit(1),new Digit(4),new Digit(7)};

        quickSort(list1, 0, list1.length-1);

        System.out.println("List 1");
        for (Digit digit : list1) {
            System.out.print(digit + ", ");
        }
    }
}
