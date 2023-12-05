package GraphTree.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch {
    private Queue<Integer> queue;
    private boolean[] visited;
    private int count;

    public BreadthFirstSearch(UnweightedGraph G, int v) {
        queue = new ArrayDeque<>();
        visited = new boolean[G.V()];
        BFS(G, v);
    }

    public void BFS(UnweightedGraph G, int v) {
        queue.add(v);
        visited[v] = true;
        count++;

        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int adj : G.adj(w)) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                    count++;
                }
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
