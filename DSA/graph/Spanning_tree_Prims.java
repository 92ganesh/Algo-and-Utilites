package DSA.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Spanning tree : For a connected and undirected graph, a spanning tree is a subgraph that is a tree
and connects all the vertices together.
Its only valid for undirected graph

Prims algo to find MSP (Minimum Spanning Tree)
TC : O(N LogN)
SC : O(N)
 */
public class Spanning_tree_Prims {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        //adj is a graph where int[2] -> v, wt
        boolean[] vis = new boolean[V];

        //int[3] -> u,v,wt
        ArrayList<int[]> spanningTree = new ArrayList<>();

        //int[2] -> u,v,wt where u is parent of v
        PriorityQueue<int[]> q = new PriorityQueue<>(V, (a,b)->a[2]-b[2]);

        q.add(new int[]{-1, 0, 0});

        while(!q.isEmpty()) {
            int[] node = q.poll();

            int u = node[0]; //parent
            int v = node[1];
            int wt = node[2];

            if(vis[v]) continue;

            vis[v] = true;

            spanningTree.add(new int[]{u, v, wt});

            for(int[] edge : adj.get(v)){
                int neighbour = edge[0];
                int neighbourWt = edge[1];
                if (!vis[neighbour]) {
                    q.add(new int[]{v, neighbour, neighbourWt});
                }
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

