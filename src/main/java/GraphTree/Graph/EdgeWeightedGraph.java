package GraphTree.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EdgeWeightedGraph {
    private int V;
    private int E;
    private List<WeightedEdge>[] adj;

    public EdgeWeightedGraph(int v) {
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

    public EdgeWeightedGraph(int v, int e) {
        this(v);
        if (e < 0) {
            throw new IllegalArgumentException("Number of edges must be non-negative");
        }

        Random random = new Random();
        for (int i = 0; i < e; i++) {
            int v1 = random.nextInt(V);
            int v2 = random.nextInt(V);
            // make sure there are no self loop edges
            while (v2 == v1) {
                v2 = random.nextInt(V);
            }
            double weight = 0.01 * random.nextInt(1, 100);
            addEdge(v1, v2, weight);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public void addEdge(int v, int w, double weight) {
        validateVertex(v);
        validateVertex(w);
        if (v == w) {
            throw new IllegalArgumentException("No self loop edges allowed");
        }

        WeightedEdge e = new WeightedEdge(v, w, weight);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public List<WeightedEdge> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public List<WeightedEdge> edges() {
        List<WeightedEdge> list = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (WeightedEdge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
            }
        }

        return list;
    }
}
