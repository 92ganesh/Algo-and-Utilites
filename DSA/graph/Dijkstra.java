package DSA.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
it calculates the shortest path from a source node to all the nodes inside the graph
TC : O(V + E log(V))
with dense graphs, where E is close to V^2 hence TC O(V + V^2 log(V))

Pros :-
graph having cycles (DG)
both directed and undirected

Cons :-
neg wt
 */
public class Dijkstra {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] minDist = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, (a,b)->a.dist-b.dist);
        pq.add(new Node(0, S));

        while(!pq.isEmpty()){
            //pick node from PQ with min dist
            Node currNode = pq.poll();
            int u = currNode.V;

            //check for update for all neighbours of this node and if any neighbour is updated then add it to PQ
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            for(ArrayList<Integer> e : neighbours){
                int v = e.get(0); int wt = e.get(1);

                if(minDist[u]+wt < minDist[v]) {
                    minDist[v] = minDist[u]+wt;

                    //this neighbour changed so add it to queue to process
                    pq.add(new Node(minDist[v], v));
                }

            }
        }

        return minDist;
    }
}

class Node{
    int dist, V;

    public Node(int dist, int v) {
        this.dist = dist;
        this.V = v;
    }
}

