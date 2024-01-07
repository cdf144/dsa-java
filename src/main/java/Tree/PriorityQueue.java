package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PriorityQueue {
    protected final List<Integer> pq;

    public PriorityQueue() {
        pq = new ArrayList<>();
    }

    public PriorityQueue(List<Integer> a) {
        pq = new ArrayList<>(a);
        for (int i = pq.size() / 2 - 1; i >= 0; i--) {
            sink(i);
        }
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public void add(int k) {
        pq.add(k);
        swim(pq.size() - 1);
    }

    public int peek() {
        return pq.get(0);
    }

    public int dequeue() {
        int top = pq.get(0);

        Collections.swap(pq, 0, pq.size() - 1);
        pq.remove(pq.size() - 1);
        sink(0);

        return top;
    }

    protected abstract void sink(int k);

    protected abstract void swim(int k);
}
