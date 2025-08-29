import java.util.*;

class Pair {
    int vertex, weight;
    Pair(int v, int w) { vertex=v; weight=w; }
}

public class PrimMST {
    static void primMST(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] inMST = new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        key[0] = 0;
        pq.add(new Pair(0,0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            inMST[u] = true;

            for (Pair it : adj.get(u)) {
                int v = it.vertex, wt = it.weight;
                if (!inMST[v] && wt < key[v]) {
                    key[v] = wt;
                    pq.add(new Pair(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        System.out.println("Edges in MST:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " (weight " + key[i] + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt)); // undirected
        }

        primMST(V, adj);
    }
}
