package GraphTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxPriorityQueue {
    public List<Integer> pq;
    public int n;

    public MaxPriorityQueue() {
        pq = new ArrayList<>();
        n = 0;
    }

    public MaxPriorityQueue(List<Integer> a) {
        pq = new ArrayList<>(a);
        n = a.size();
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void sink(int k) {
        int father = k;
        int leftChild = 2*k + 1;
        int rightChild = 2*k + 2;

        if (leftChild < n && pq.get(leftChild).compareTo(pq.get(father)) > 0) {
            father = leftChild;
        }

        if (rightChild < n && pq.get(rightChild).compareTo(pq.get(father)) > 0) {
            father = rightChild;
        }

        if (father != k) {
            Collections.swap(pq, father, k);
            sink(father);
        }
    }

    public void swim(int k) {
        if (k == 0) {
            return;
        }

        int father;
        if (k % 2 == 0) {
            father = k/2 - 1;
        } else {
            father = k/2;
        }

        if (pq.get(k).compareTo(pq.get(father)) > 0) {
            Collections.swap(pq, father, k);
            swim(k);
        }
    }


}
