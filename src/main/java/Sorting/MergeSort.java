package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static final int CUTOFF = 8;

    public static <T extends Comparable<T>> List<T> sort(List<T> arr) {
        if (arr.size() <= 1) return arr;
        if (arr.size() <= CUTOFF) {
            InsertionSort.sort(arr);
            return arr;
        }

        int mid = arr.size() / 2;

        List<T> left = sort(new ArrayList<>(arr.subList(0, mid)));
        List<T> right = sort(new ArrayList<>(arr.subList(mid, arr.size())));

        return merge(left, right);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        int i = 0; // left array index
        int j = 0; // right array index
        List<T> mergedList = new ArrayList<>();

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                mergedList.add(left.get(i));
                i++;
            } else {
                mergedList.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            mergedList.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            mergedList.add(right.get(j));
            j++;
        }

        return mergedList;
    }
}
