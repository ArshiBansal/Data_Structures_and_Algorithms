#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void dijkstra(int V, vector<vector<pair<int,int>>>& adj, int src) {
    vector<int> dist(V, 1e9);
    dist[src] = 0;

    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    pq.push({0, src});

    while (!pq.empty()) {
        int d = pq.top().first;
        int node = pq.top().second;
        pq.pop();

        for (auto it : adj[node]) {
            int v = it.first, wt = it.second;
            if (d + wt < dist[v]) {
                dist[v] = d + wt;
                pq.push({dist[v], v});
            }
        }
    }

    cout << "Shortest distances from source " << src << ":\n";
    for (int i = 0; i < V; i++) cout << i << " -> " << dist[i] << "\n";
}

int main() {
    int V, E; cin >> V >> E;
    vector<vector<pair<int,int>>> adj(V);

    for (int i = 0; i < E; i++) {
        int u, v, wt;
        cin >> u >> v >> wt;
        adj[u].push_back({v, wt});
        adj[v].push_back({u, wt}); // undirected
    }

    int src; cin >> src;
    dijkstra(V, adj, src);
}
