package 图;

import java.util.Arrays;

public class leet684 {
    public int[] findRedundantConnection(int[][] edges) {
        int nodeCount = edges.length;
        int[] parent = new int[nodeCount+1];
        //初始化parent
        for (int i = 0; i < nodeCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodeCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            System.out.println(Arrays.toString(parent));
            if(findParent(parent,node1) != findParent(parent,node2)){
                union(parent,node1,node2);
            }else {
                return edge;
            }
        }
        return new int[0];
    }
    public void union(int[] parent,int node1,int node2){
        parent[findParent(parent,node1)] = findParent(parent,node2);
    }
    public int findParent(int[] parent,int node){
        if(parent[node] != node){
            parent[node] = findParent(parent,parent[node]);
        }
        return parent[node];
    }

}
