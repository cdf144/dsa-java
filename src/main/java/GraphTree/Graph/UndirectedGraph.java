package GraphTree.Graph;

public class UndirectedGraph extends UnweightedGraph {
    public UndirectedGraph(int v) {
        super(v);
    }

    @Override
    public void addEdge(int u, int v) {
        validateVertex(u);
        validateVertex(v);
        E++;
        adj[u].add(v);
        adj[v].add(u);
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
}
