package Graph;

import java.util.LinkedList;
import java.util.List;

public abstract class UnweightedGraph {
    protected final int V;
    protected int E;
    protected List<Integer>[] adj;

    public UnweightedGraph(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }

        V = v;
        E = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void validateVertex(int v) {
        if (v < 0 && v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    public List<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public abstract void addEdge(int u, int v);
}
