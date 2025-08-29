//using dfs

import java.util.*;

public class toposort {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, st);
            }
        }
        st.push(node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vertices and edges: ");
        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        System.out.println("Enter directed edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }

        System.out.print("Topological Order (DFS): ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        sc.close();
    }
}
