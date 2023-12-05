package Graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimMST {
    private WeightedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private PriorityQueue<WeightedEdge> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new WeightedEdge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new PriorityQueue<>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                prim(G, v);
            }
        }
    }

    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        scan(G, s);
        while (!pq.isEmpty()) {
            WeightedEdge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            } else if (marked[v]) {
                scan(G, w);
            } else {
                scan(G, v);
            }
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (WeightedEdge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;
            }

            pq.add(e);
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public Iterable<WeightedEdge> edges() {
        Queue<WeightedEdge> mst = new LinkedList<>();
        for (WeightedEdge e : edgeTo) {
            if (e != null) {
                mst.add(e);
            }
        }

        return mst;
    }

    public double weight() {
        double totalWeight = 0.0;
        for (WeightedEdge e : edges()) {
            totalWeight += e.weight();
        }

        return totalWeight;
    }
}
