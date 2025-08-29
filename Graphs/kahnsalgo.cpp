#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    int V, E;
    cout << "Enter vertices and edges: ";
    cin >> V >> E;

    vector<vector<int>> adj(V);
    vector<int> indegree(V, 0);

    cout << "Enter directed edges (u v):\n";
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        indegree[v]++;
    }

    queue<int> q;
    for (int i = 0; i < V; i++) {
        if (indegree[i] == 0) q.push(i);
    }

    cout << "Topological Order (Kahn's BFS): ";
    while (!q.empty()) {
        int node = q.front();
        q.pop();
        cout << node << " ";

        for (int neighbor : adj[node]) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) q.push(neighbor);
        }
    }
    return 0;
}
