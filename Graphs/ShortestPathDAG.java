//Shortest Path in DAG

import java.util.*;

public class ShortestPathDAG {
    static void dfs(int node, ArrayList<ArrayList<int[]>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (int[] edge : adj.get(node)) {
            if (!vis[edge[0]]) dfs(edge[0], adj, vis, st);
        }
        st.push(node);
    }

    static void shortestPath(int V, ArrayList<ArrayList<int[]>> adj, int src) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) if (!vis[i]) dfs(i, adj, vis, st);

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != 1e9) {
                for (int[] edge : adj.get(node)) {
                    int v = edge[0], wt = edge[1];
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            adj.get(u).add(new int[]{v, wt}); // directed edge
        }

        int src = sc.nextInt();
        shortestPath(V, adj, src);
    }
}
