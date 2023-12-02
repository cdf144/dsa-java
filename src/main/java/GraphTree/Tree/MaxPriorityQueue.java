package GraphTree.Tree;

import java.util.Collections;
import java.util.List;

public class MaxPriorityQueue extends PriorityQueue {
    public MaxPriorityQueue() {
        super();
    }

    public MaxPriorityQueue(List<Integer> a) {
        super(a);
    }

    protected void sink(int k) {
        int father = k;
        int leftChild = 2*k + 1;
        int rightChild = 2*k + 2;

        if (leftChild < pq.size() && pq.get(leftChild).compareTo(pq.get(father)) > 0) {
            father = leftChild;
        }

        if (rightChild < pq.size() && pq.get(rightChild).compareTo(pq.get(father)) > 0) {
            father = rightChild;
        }

        if (father != k) {
            Collections.swap(pq, father, k);
            sink(father);
        }
    }

    protected void swim(int k) {
        if (k == 0) {
            return;
        }

        int father;
        if (k%2 == 0) {
            father = k/2 - 1;
        } else {
            father = k/2;
        }

        if (pq.get(k).compareTo(pq.get(father)) > 0) {
            Collections.swap(pq, father, k);
            swim(father);
        }
    }
}
