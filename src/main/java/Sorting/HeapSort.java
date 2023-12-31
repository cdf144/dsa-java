package Sorting;

import java.util.List;

public class HeapSort {

    /**
     * Heap sort method.
     * @param arr Array to sort
     */
    public static <T extends Comparable<T>> void sort(List<T> arr) {
        buildMaxHeap(arr);

        for (int i = arr.size() - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    /**
     * Build a max heap from an Array.
     * @param arr Array to build a max heap from
     */
    private static <T extends Comparable<T>> void buildMaxHeap(List<T> arr) {
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.size());
        }
    }

    /**
     * Turn binary trees (heaps) into max heap by making sure
     * that in each subtree, a father is always larger than
     * its 2 children. If a switch is made (in other words,
     * originally, the father is not larger than its 2 children),
     * then recursively max-heapify the subtree in which the
     * father is the element that was switched (or the element
     * that was the smallest in the previous subtree).
     * @param arr Array to max-heapify on
     * @param originalFather Index of father node of subtree
     * @param arrSize Array size for checking if a child does not exist
     *                (out of bound)
     */
    private static <T extends Comparable<T>> void maxHeapify(List<T> arr, int originalFather, int arrSize) {
        int father = originalFather;
        int leftChild = 2 * originalFather + 1;
        int rightChild = 2 * originalFather + 2;

        if (leftChild < arrSize && arr.get(leftChild).compareTo(arr.get(father)) > 0) {
            father = leftChild;
        }

        if (rightChild < arrSize && arr.get(rightChild).compareTo(arr.get(father)) > 0) {
            father = rightChild;
        }

        if (father != originalFather) {
            swap(arr, originalFather, father);
            maxHeapify(arr, father, arrSize);
        }
    }

    /**
     * Method to swap 2 elements of an Array (List)
     * at 2 indexes.
     * @param arr Array (List)
     * @param idx1 first element index
     * @param idx2 second element index
     */
    private static <T extends Comparable<T>> void swap(List<T> arr, int idx1, int idx2) {
        T tmp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, tmp);
    }
}

