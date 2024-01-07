package Graph;

import java.util.NoSuchElementException;

class IndexMinPQ<Key extends Comparable<Key>> {
    private int maxSize;
    private int size;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMinPQ(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException();
        }

        this.maxSize = maxSize;
        size = 0;
        keys = (Key[]) new Comparable[maxSize + 1];
        pq = new int[maxSize + 1];
        qp = new int[maxSize + 1];
        for (int i = 0; i <= maxSize; i++) {
            qp[i] = -1;
        }
    }

    private void validateIndex(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index is negative: " + i);
        }
        if (i >= maxSize) {
            throw new IllegalArgumentException("index >= capacity: " + i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int i) {
        validateIndex(i);
        return qp[i] != -1;
    }

    public int size() {
        return size;
    }

    public void insert(int i, Key key) {
        validateIndex(i);
        if (contains(i)) {
            throw new IllegalArgumentException("index is already in the priority queue");
        }
        size++;
        qp[i] = size;
        pq[size] = i;
        keys[i] = key;
    }

    public int minIndex() {
        if (size == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }
}

public class DijkstraSP {
    private double[] distTo;
    private WeightedEdge[] edgeTo;

}
