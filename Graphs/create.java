//Adjacency Matrix Representation

import java.util.Scanner;

public class create {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] adj = new int[V][V]; // adjacency matrix

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1; // for undirected graph
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(adj[i][j] + " ");
            System.out.println();
        }
        sc.close();
    }
}

//Adjacency List Representation

/*
 import java.util.*;

public class GraphList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // for undirected graph
        }

        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int v : adj.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

 */