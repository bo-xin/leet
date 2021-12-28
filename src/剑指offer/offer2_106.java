package 剑指offer;

/**
 * @program: leet
 * @description: 二分图
 * @author: Tb
 * @create: 2021-12-27 20:48
 **/
public class offer2_106 {
    int[] color;
    int[][] graph;
    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if(color[i] != 0) continue;
            if(!dfs(i,1)) return false;
        }
        return true;
    }
    public boolean dfs(int node, int c){
        if(color[node] != 0){
            return color[node] == c;
        }
        color[node] = c;
        int nextC = c == 1? 2 : 1;
        for (int next : graph[node]) {
            if(!dfs(next,nextC)) return false;
        }
        return true;
    }

}
