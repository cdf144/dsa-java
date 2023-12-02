package GraphTree.Graph;

public class DirectedGraph extends Graph {
    private int[] indegree;

    public DirectedGraph(int v) {
        super(v);
        indegree = new int[v];
    }

    @Override
    public void addEdge(int u, int v) {
        validateVertex(u);
        validateVertex(v);
        E++;
        adj[u].add(v);
        indegree[v]++;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    public DirectedGraph reverse() {
        DirectedGraph reverse = new DirectedGraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }

        return reverse;
    }
}
