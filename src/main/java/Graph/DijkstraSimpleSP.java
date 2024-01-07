package Graph;

import java.util.PriorityQueue;
import java.util.Stack;

class Cost {
    int v;
    double dist;

    public Cost(int v, double dist) {
        this.v = v;
        this.dist = dist;
    }

    public int vertex() {
        return v;
    }

    public double dist() {
        return dist;
    }
}

public class DijkstraSimpleSP {
    private double[] distTo;
    private WeightedEdge[] edgeTo;
    private PriorityQueue<Cost> pq;

    public DijkstraSimpleSP(EdgeWeightedGraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new WeightedEdge[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq = new PriorityQueue<>((c1, c2) -> Double.compare(c1.dist(), c2.dist()));
        pq.add(new Cost(s, distTo[s]));
        while (!pq.isEmpty()) {
            Cost cost = pq.poll();
            for (WeightedEdge e : G.adj(cost.vertex())) {
                relax(e, cost.vertex());
            }
        }
    }

    private void relax(WeightedEdge e, int v) {
        int w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            pq.add(new Cost(w, distTo[w]));
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<WeightedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<WeightedEdge> path = new Stack<>();
        int x = v;
        for (WeightedEdge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }

        return path;
    }
}
