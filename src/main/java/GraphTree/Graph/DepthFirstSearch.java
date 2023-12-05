package GraphTree.Graph;

public class DepthFirstSearch {
    private boolean[] visited;
    private int count;

    public DepthFirstSearch(UnweightedGraph G, int v) {
        visited = new boolean[G.V()];
        DFS(G, v);
    }

    public void DFS(UnweightedGraph G, int v) {
        count++;
        visited[v] = true;
        for (int adj : G.adj(v)) {
            if (!visited[adj]) {
                DFS(G, adj);
            }
        }
    }

    public boolean visited(int v) {
        return visited[v];
    }

    public int count() {
        return count;
    }
}
