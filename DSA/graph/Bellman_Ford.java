package DSA.graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
it calculates the shortest path from a source node to all the nodes inside the graph
we perform V - 1 steps, For each edge from node u to v, we update the respective distances of v if needed
T : O(V E)

Pros :-
graph having cycles (DG)
both directed and undirected
with neg wt (which is not supported in Dijkstra)
check existence of neg cycles

Cons :-
higher TC than dijkstra
 */

/* Solved on GFG
 *   edges: vector of vectors which represents the graph, [u,v,wt]
 *   S: source vertex to start traversing graph with
 *   V: number of vertices
 */
public class Bellman_Ford {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[S] = 0;

        //relaxation of edges V-1 times
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                if(dist[u]!=(int)1e8)
                    dist[v] =  Math.min(dist[v], dist[u]+wt);
            }
        }

        //detect negative cycles : if values still change after V-1 relaxations then the graph has neg cycles
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                if( (dist[u]!=(int)1e8) && dist[u]+wt < dist[v]){
                    return new int[]{-1};
                }
            }
        }

        return dist;
    }
}