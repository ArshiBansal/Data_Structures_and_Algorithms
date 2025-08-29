import java.util.*;

class Edge implements Comparable<Edge> {
    int u,v,wt;
    Edge(int u,int v,int wt){this.u=u;this.v=v;this.wt=wt;}
    public int compareTo(Edge other){ return this.wt - other.wt; }
}

public class KruskalMST {
    static int findParent(int u,int[] parent){
        if(parent[u]==u) return u;
        return parent[u]=findParent(parent[u],parent);
    }

    static void unionSet(int u,int v,int[] parent,int[] rank){
        u=findParent(u,parent); v=findParent(v,parent);
        if(rank[u]<rank[v]) parent[u]=v;
        else if(rank[u]>rank[v]) parent[v]=u;
        else { parent[v]=u; rank[u]++; }
    }

    static void kruskalMST(int V, ArrayList<Edge> edges){
        Collections.sort(edges);
        int[] parent=new int[V]; int[] rank=new int[V];
        for(int i=0;i<V;i++) parent[i]=i;

        System.out.println("Edges in MST:");
        for(Edge e: edges){
            if(findParent(e.u,parent)!=findParent(e.v,parent)){
                System.out.println(e.u+" - "+e.v+" (weight "+e.wt+")");
                unionSet(e.u,e.v,parent,rank);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt(),E=sc.nextInt();
        ArrayList<Edge> edges=new ArrayList<>();
        for(int i=0;i<E;i++){
            int u=sc.nextInt(),v=sc.nextInt(),wt=sc.nextInt();
            edges.add(new Edge(u,v,wt));
        }

        kruskalMST(V,edges);
    }
}
