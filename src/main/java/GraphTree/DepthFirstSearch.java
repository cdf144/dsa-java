package GraphTree;

public class DepthFirstSearch {
    private boolean[] visited;
    private int count;

    public DepthFirstSearch(UndirectedGraph G, int v) {
        visited = new boolean[G.V()];

    }

    public void DFS(UndirectedGraph G, int v) {
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
