package DSA.graph;

import java.util.Arrays;

public class DisjointSetUnion {
    int[] elements;
    static int[] parent, rank, size;
    DisjointSetUnion(int[] ele){
        elements = ele;
        parent = new int[elements.length];
        for(int i=0; i<parent.length; i++){
            parent[i] = elements[i];
        }

        //Union by rank
        rank = new int[elements.length];

        //Union by size
        size = new int[elements.length];
        Arrays.fill(size, 1);
    }


    //Find ultimate parent while doing path compression
    int find(int X) {
        if (parent[X]==elements[X]) {
            return parent[X];
        }else{
            int ultParent = find(parent[X]);
            parent[X]=ultParent;
            return ultParent;
        }
    }

    void unionByRank(int X,int Z) {
        int parX = find(X);
        int parZ = find(Z);

        if(rank[parX]<rank[parZ]){
            parent[parX] = parent[parZ];
        }else if(rank[parX]>rank[parZ]){
            parent[parZ] = parent[parX];
        }else{
            parent[parX] = parent[parZ];
            rank[parZ]++;
        }
    }

    void unionBySize(int X,int Z) {
        int parX = find(X);
        int parZ = find(Z);

        if(size[parX]<=size[parZ]){
            parent[parX] = parent[parZ];
            size[parZ] += size[parX];
        }else {
            parent[parZ] = parent[parX];
            size[parX] += size[parZ];
        }
    }
}
