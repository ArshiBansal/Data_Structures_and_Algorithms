//Adjacency Matrix Representation

#include <iostream>
using namespace std;

int main() {
    int V, E;
    cout << "Enter number of vertices and edges: ";
    cin >> V >> E;

    int adj[V][V]; // adjacency matrix
    for(int i = 0; i < V; i++)
        for(int j = 0; j < V; j++)
            adj[i][j] = 0; // initialize with 0

    cout << "Enter edges (u v):\n";
    for(int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        adj[u][v] = 1;
        adj[v][u] = 1; // for undirected graph
    }

    cout << "Adjacency Matrix:\n";
    for(int i = 0; i < V; i++) {
        for(int j = 0; j < V; j++)
            cout << adj[i][j] << " ";
        cout << endl;
    }
    return 0;
}

//Adjacency List Representation

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int V, E;
    cout << "Enter number of vertices and edges: ";
    cin >> V >> E;

    vector<int> adj[V]; // adjacency list

    cout << "Enter edges (u v):\n";
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u); // for undirected graph
    }

    cout << "Adjacency List:\n";
    for (int i = 0; i < V; i++) {
        cout << i << " -> ";
        for (int v : adj[i])
            cout << v << " ";
        cout << endl;
    }
    return 0;
}
