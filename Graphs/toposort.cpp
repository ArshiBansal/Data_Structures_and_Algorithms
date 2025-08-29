//using dfs

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

void dfs(int node, vector<vector<int>>& adj, vector<bool>& visited, stack<int>& st) {
    visited[node] = true;
    for (int neighbor : adj[node]) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited, st);
        }
    }
    st.push(node);
}

int main() {
    int V, E;
    cout << "Enter vertices and edges: ";
    cin >> V >> E;

    vector<vector<int>> adj(V);
    cout << "Enter directed edges (u v):\n";
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v); // directed edge
    }

    vector<bool> visited(V, false);
    stack<int> st;

    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            dfs(i, adj, visited, st);
        }
    }

    cout << "Topological Order (DFS): ";
    while (!st.empty()) {
        cout << st.top() << " ";
        st.pop();
    }
    return 0;
}
