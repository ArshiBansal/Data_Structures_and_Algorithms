import java.util.*;

public class kahnsalgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vertices and edges: ");
        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[V];

        System.out.println("Enter directed edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        System.out.print("Topological Order (Kahn's BFS): ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
        }
        sc.close();
    }
}
