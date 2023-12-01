package Sorting;

import java.util.List;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(List<T> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;

        for (int i = 1; i < arr.size(); i++) {
            T val = arr.get(i);
            int j = i - 1;

            while (j >= 0 && val.compareTo(arr.get(j)) < 0) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, val);
        }
    }
}
