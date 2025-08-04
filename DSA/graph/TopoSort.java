package DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u-v, vertex u comes before v in the ordering.
Note: Topological Sorting for a graph is not possible if the graph is not a DAG.
TC : O(N)
SC : O(N)

Pros :-
used to detect cycle. Toposort is not possible for graphs having cycles
Dependency check (course scheduling prob on leetcode)

Two way to do it:-
DFS and BFS(kahn's algo)
 */

class TopoSort_DFS {
    static ArrayList<Integer> topoSorted;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] vis;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        topoSorted = new ArrayList<>();
        graph = adj;
        vis = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]) dfs(i);
        }

        int[] re = new int[V];
        for(int i=0; i<topoSorted.size(); i++){
            re[V-i-1] = topoSorted.get(i);
        }

        return re;
    }

    static void dfs(int node) {
        vis[node] = true;
        for(int e : graph.get(node)){
            if (!vis[e]) dfs(e);
        }
        topoSorted.add(node);
    }
}

class Toposort_BFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegrees = new int[V];

        //Calc indegree of all nodes
        for(int i=0;i<V;i++){
            for(int e : adj.get(i)){
                indegrees[e]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        //add indegree 0 to q
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        int[] topoSorted = new int[V]; int topoInd=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topoSorted[topoInd] = node;
            topoInd++;

            //reduce indegree of all neighbours and add to queue if reach to 0
            for(int e : adj.get(node)){
                indegrees[e]--;
                if(indegrees[e]==0){
                    q.add(e);
                }
            }
        }

        //cycle detection
        if(topoInd != V-1){
            System.out.println("All vertices are not added to toposort means cycle exists hence cannot generate toposort");
        }

        /*Alternate way to check cycle. If any indegree is still not 0 after processing then cycle exists
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]!=0) {
                System.out.println("cycle exists hence cannot generate toposort");
            }
        }
        */

        return topoSorted;
    }
}
