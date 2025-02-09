package DSA.graph;

import java.util.Arrays;

/*
 shortest distance from each node to every other node.

 TC : O( N^3 )

 Pros :
 neg wt
 detect neg cycle (if dist[i][i] is neg instead of 0 after the complete execution)
 */
public class Floyd_warshall {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        for(int k=0; k<n ; k++){
            for(int i=0; i<n ; i++){
                for(int j=0; j<n ; j++){
                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
                }
            }
        }
    }
}
