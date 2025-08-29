import java.util.*;

public class Dijkstra {
    static void dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1];

            for (int[] edge : adj.get(node)) {
                int v = edge[0], wt = edge[1];
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    pq.add(new int[]{dist[v], v});
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
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt}); // undirected
        }

        int src = sc.nextInt();
        dijkstra(V, adj, src);
    }
}
