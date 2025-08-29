import java.util.*;

public class Kosaraju {
    
    static void dfs1(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        for(int v : adj.get(u)) {
            if(!visited[v]) dfs1(v, adj, visited, st);
        }
        st.push(u); // push after all neighbors are visited
    }

    static void dfs2(int u, ArrayList<ArrayList<Integer>> trans, boolean[] visited, List<Integer> component) {
        visited[u] = true;
        component.add(u);
        for(int v : trans.get(u)) {
            if(!visited[v]) dfs2(v, trans, visited, component);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> trans = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            trans.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            trans.get(v).add(u); // transpose edge
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        // Step 1: DFS on original graph to fill stack
        for(int i = 0; i < V; i++) {
            if(!visited[i]) dfs1(i, adj, visited, st);
        }

        Arrays.fill(visited, false);
        System.out.println("Strongly Connected Components:");

        // Step 2 & 3: DFS on transposed graph using stack
        while(!st.isEmpty()) {
            int u = st.pop();
            if(!visited[u]) {
                List<Integer> component = new ArrayList<>();
                dfs2(u, trans, visited, component);
                System.out.println(component);
            }
        }
    }
}
