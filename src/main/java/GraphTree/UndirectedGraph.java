package GraphTree;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public UndirectedGraph(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }

        V = v;
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
        if (v >= 0 && v < V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    public void addEdge(int u, int v) {
        validateVertex(u);
        validateVertex(v);
        E++;
        adj[u].add(v);
        adj[v].add(u);
    }

    public List<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
}
