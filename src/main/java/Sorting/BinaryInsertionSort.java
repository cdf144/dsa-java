package Sorting;

import java.util.List;

public class BinaryInsertionSort {
    public static <T extends Comparable<T>> void sort(List<T> arr) {
        if (arr.isEmpty() || arr.size() == 1) return;
        for (int i = 1; i < arr.size(); i++) {
            int location = binarySearch(arr, i, arr.get(i));
            insert(arr, i, location);
        }
    }

    // Find right slot using Binary search
    private static <T extends Comparable<T>> int binarySearch(List<T> arr, int high, T key) {
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid).compareTo(key) > 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static <T extends Comparable<T>> void insert(List<T> arr, int high, int location) {
        int i = high;
        T value = arr.get(high);
        for (; i > location; i--) {
            arr.set(i, arr.get(i - 1));
        }
        arr.set(i, value);
    }
}
