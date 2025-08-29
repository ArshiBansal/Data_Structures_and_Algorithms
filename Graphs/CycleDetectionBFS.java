import java.util.*;

public class CycleDetectionBFS {
    static boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];

        // Step 1: Calculate indegree of all nodes
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // Step 2: Push nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int count = 0; // visited nodes

        // Step 3: BFS
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
        }

        // Step 4: Check
        return (count != V); // if not all nodes visited → cycle exists
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
            adj.get(u).add(v); // directed edge
        }

        if (hasCycle(V, adj))
            System.out.println("Cycle exists in the directed graph");
        else
            System.out.println("No cycle (Graph is a DAG)");

        sc.close();
    }
}
