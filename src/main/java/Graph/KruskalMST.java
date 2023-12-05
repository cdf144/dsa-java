package Graph;

import Array.UnionFind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KruskalMST {
    private double weight;
    private Queue<WeightedEdge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        WeightedEdge[] edges = new WeightedEdge[G.E()];
        int t = 0;
        for (WeightedEdge e : G.edges()) {
            edges[t++] = e;
        }
        Arrays.sort(edges, (e1, e2) -> Double.compare(e1.weight(), e2.weight()));

        kruskal(G, edges);
    }

    private void kruskal(EdgeWeightedGraph G, WeightedEdge[] sortedEdges) {
        UnionFind uf = new UnionFind(G.V());
        for (int i = 0; i < G.E() && mst.size() < (G.V() - 1); i++) {
            WeightedEdge e = sortedEdges[i];
            int v = e.either();
            int w = e.other(v);

            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e);
                weight += e.weight();
            }
        }
    }

    public double weight() {
        return weight;
    }

    public Iterable<WeightedEdge> edges() {
        return mst;
    }
}
