import java.util.*;

class Edge {
    int u, v, wt;
    Edge(int u, int v, int wt) {
        this.u = u; this.v = v; this.wt = wt;
    }
}

public class BellmanFordAlgo {
    static void bellmanFord(int V, ArrayList<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        // Step 1: Relax edges V-1 times
        for (int i = 1; i <= V - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != 1e9 && dist[e.u] + e.wt < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.wt;
                }
            }
        }

        // Step 2: Detect negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != 1e9 && dist[e.u] + e.wt < dist[e.v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            edges.add(new Edge(u, v, wt));
        }

        int src = sc.nextInt();
        bellmanFord(V, edges, src);
    }
}
