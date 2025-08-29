#include <bits/stdc++.h>
using namespace std;

vector<int> disc, low, parent;
int time1 = 0;

void bridgeDFS(int u, vector<vector<int>>& adj){
    disc[u] = low[u] = ++time1;
    for(int v : adj[u]){
        if(disc[v]==-1){ // not visited
            parent[v] = u;
            bridgeDFS(v, adj);
            low[u] = min(low[u], low[v]);
            if(low[v] > disc[u]) cout << u << " - " << v << " is a bridge\n";
        }
        else if(v != parent[u]) low[u] = min(low[u], disc[v]);
    }
}

int main(){
    int V,E;
    cin >> V >> E;
    vector<vector<int>> adj(V);
    for(int i=0;i<E;i++){
        int u,v; cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u); // undirected
    }
    disc.assign(V,-1); low.assign(V,-1); parent.assign(V,-1);
    for(int i=0;i<V;i++) if(disc[i]==-1) bridgeDFS(i, adj);
}
