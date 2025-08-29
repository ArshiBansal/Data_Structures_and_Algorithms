//Shortest Path in UG with unit weights

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void shortestPathUG(int V, vector<vector<int>>& adj, int src) {
    vector<int> dist(V, 1e9);
    dist[src] = 0;

    queue<int> q;
    q.push(src);

    while (!q.empty()) {
        int node = q.front();
        q.pop();

        for (int neighbor : adj[node]) {
            if (dist[node] + 1 < dist[neighbor]) {
                dist[neighbor] = dist[node] + 1;
                q.push(neighbor);
            }
        }
    }

    cout << "Shortest distances from source " << src << ":\n";
    for (int i = 0; i < V; i++) cout << i << " -> " << dist[i] << "\n";
}

int main() {
    int V, E;
    cin >> V >> E;
    vector<vector<int>> adj(V);

    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u); // undirected
    }

    int src;
    cin >> src;
    shortestPathUG(V, adj, src);
}
