package DSA.graph;

import java.util.*;

/*
Spanning tree : For a connected and undirected graph, a spanning tree is a subgraph that is a tree
and connects all the vertices together.
Its only valid for undirected graph

Kruskals algo to find MSP (Minimum Spanning Tree)
TC : O(N LogN)
SC : O(N)
*/
public class Spanning_tree_kruskals {

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        //adj is a graph where int[2] -> v, wt
        boolean[] vis = new boolean[V];

        //int[3] -> u,v,wt
        ArrayList<int[]> spanningTree = new ArrayList<>();

        //int[2] -> u,v,wt
        List<int[]> edges = new ArrayList<>();

        for(int i=0;i<V;i++){
            for(int[] e : adj.get(i)){
                edges.add(new int[]{i, e[0], e[1]});
            }
        }

        Collections.sort(edges, (a,b)->a[2]-b[2]);

        int[] ele = new int[V];
        for(int i=0;i<V;i++){
            ele[i]=i;
        }

        DisjointSetUnion dsu = new DisjointSetUnion(ele);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            //Using DSU, check whether cycle forms by connecting u and v
            int parU = dsu.find(u);
            int parV = dsu.find(v);

            if(parU!=parV){
                dsu.unionBySize(u,v);
                spanningTree.add(new int[]{u,v,wt});
            }
        }

        int sum=0;
        for(int[] e : spanningTree){
            //System.out.println(Arrays.toString(e));
            sum+=e[2];
        }

        return sum;
    }
}