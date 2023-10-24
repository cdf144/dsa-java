import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UnionFind {
    private final List<Integer> parent;
    private final List<Integer> size;

    public UnionFind() {
        parent = new ArrayList<>();
        size = new ArrayList<>();
    }

    public UnionFind(int N) {
        parent = new ArrayList<>(N);
        size = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public List<Integer> getId() {
        return parent;
    }

    public List<Integer> getSize() {
        return size;
    }

    public boolean isConnected(int p, int q) {
        return Objects.equals(getRoot(p), getRoot(q));
    }

    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (size.get(pRoot) <= size.get(qRoot)) {
            parent.set(pRoot, qRoot);
            size.set(qRoot, size.get(qRoot) + size.get(pRoot));
        } else {
            parent.set(qRoot, pRoot);
            size.set(pRoot, size.get(pRoot) + size.get(qRoot));
        }
    }

    public int getRoot(int p) {
        /*
        if (p == parent.get(p)) return p;
        return parent.set(parent.get(p), getRoot(parent.get(p)));
         */
        while (p != parent.get(p)) {
            parent.set(parent.get(p), parent.get(parent.get(p)));
            p = parent.get(p);
        }
        return p;
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(0, 2);
        System.out.println(unionFind.isConnected(0, 2));

        unionFind.union(3, 2);
        System.out.println(unionFind.isConnected(0, 3));

        unionFind.union(8, 9);
        unionFind.union(2, 9);
        System.out.println(unionFind.isConnected(0, 8));
        System.out.println(unionFind.getSize().get(2));
        System.out.println(unionFind.getSize().get(9));

        unionFind.union(9, 7);
        System.out.println(unionFind.getSize().get(2));
        System.out.println(unionFind.getSize().get(9));
    }
}
