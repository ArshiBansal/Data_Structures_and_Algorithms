import java.util.*;

public class FloydWarshallAlgo {
    static void floydWarshall(int V, int[][] graph) {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != (int)1e9 && dist[k][j] != (int)1e9)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        System.out.println("All Pairs Shortest Path Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == (int)1e9) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) Arrays.fill(graph[i], (int)1e9);
        for (int i = 0; i < V; i++) graph[i][i] = 0;

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            graph[u][v] = wt; // directed
        }

        floydWarshall(V, graph);
    }
}
